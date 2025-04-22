package com.sonns.business.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.sonns.business.config.CloudinaryConfig;
import com.sonns.business.dto.*;
import com.sonns.business.repo.PostMediaRepo;
import com.sonns.business.repo.PostsRepo;
import com.sonns.business.repo.ReactionCommentService;
import com.sonns.business.services.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService {

    private final PostsRepo postsRepo;
    private final ReactionCommentService reactionCommentService;
    private final Cloudinary cloudinary;
    private final PostMediaRepo postMediaRepo;

    @Override
    public void createPost(PostCreateRequest post) {
        PostsDto dto = postsRepo.createPost(post);

        List<MultipartFile> files = post.getFiles();
        if (files != null && !files.isEmpty()) {
            for (MultipartFile file : files) {
                String imageUrl = null;

                try {
                    String nameImage = dto.getId() + "_" + file.getOriginalFilename();
                    imageUrl = uploadImage(file, nameImage);

                    postMediaRepo.savePostMedia(PostMediaDto.builder()
                                    .postId(dto.getId())
                                    .mediaUrl(imageUrl)
                                    .build());

                } catch (IOException e) {
                    throw new RuntimeException("Upload failed for one file", e);
                }

            }
        }
    }

    public String uploadImage(MultipartFile file, String customFileName) throws IOException {
        String publicId = "HealthSocialNetwork/" + customFileName;

        Map uploadResult = cloudinary.uploader().upload(file.getBytes(),
                ObjectUtils.asMap(
                        "resource_type", "auto",
                        "public_id", publicId));

        return uploadResult.get("secure_url").toString();
    }

    @Override
    public Page<PostsResponse> getPosts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<PostsProxyDto> postsPage = postsRepo.getPosts(pageable);

        List<PostsResponse> responses = postsPage.stream()
                .map(post -> {
                    PostStatsResponse stats = reactionCommentService.getPostStats(post.getId()).block();
                    return PostsResponse.builder()
                            .id(post.getId())
                            .content(post.getContent())
                            .likes(stats.getLikeCount())
                            .comments(stats.getCommentCount())
                            .repost(post.getRepost())
                            .createdAt(post.getCreatedAt())
                            .updatedAt(post.getUpdatedAt())
                            .build();
                })
                .collect(Collectors.toList());

        return new PageImpl<>(responses, pageable, postsPage.getTotalElements());
    }
}
