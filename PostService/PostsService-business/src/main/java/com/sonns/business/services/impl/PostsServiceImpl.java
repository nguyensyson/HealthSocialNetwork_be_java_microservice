package com.sonns.business.services.impl;

import com.sonns.business.dto.*;
import com.sonns.business.dto.proxy.PostsProxyDto;
import com.sonns.business.repo.PostMediaRepo;
import com.sonns.business.repo.PostsRepo;
import com.sonns.business.repo.ReactionCommentService;
import com.sonns.business.services.PostsService;
import com.sonns.business.services.UploadImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService {

    private final PostsRepo postsRepo;
    private final ReactionCommentService reactionCommentService;
    private final PostMediaRepo postMediaRepo;
    private final UploadImageService uploadImageService;

    @Override
    @Transactional
    public Boolean createPost(PostCreateRequest post) {
        try {
            PostsDto dto = postsRepo.createPost(post);

            List<MultipartFile> files = post.getFiles();
            if (files != null && !files.isEmpty()) {
                for (MultipartFile file : files) {
                    String imageUrl = null;
                    String nameImage = dto.getId() + "_" + file.getOriginalFilename();
                    imageUrl = uploadImageService.uploadImage(file, nameImage);

                    postMediaRepo.savePostMedia(PostMediaDto.builder()
                                    .postId(dto.getId())
                                    .name(nameImage)
                                    .mediaUrl(imageUrl)
                                    .build());

                }
            }
        return true;
        } catch (Exception e) {
            return false;
        }
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

    @Override
    @Transactional
    public Boolean updatePost(String id, PostCreateRequest post) {
        try {
            PostsDto dto = postsRepo.getPostById(id);
            List<PostMediaDto> currentMedias = dto.getMediaImages();

            List<MultipartFile> uploadedFiles = post.getFiles();
            List<String> uploadedFileNames = new ArrayList<>();

            if (uploadedFiles != null && !uploadedFiles.isEmpty()) {
                for (MultipartFile file : uploadedFiles) {
                    String originalName = file.getOriginalFilename();
                    String generatedName = dto.getId() + "_" + originalName;
                    uploadedFileNames.add(generatedName);

                    // Kiểm tra file đã tồn tại chưa
                    boolean exists = currentMedias.stream()
                            .anyMatch(media -> media.getMediaUrl() != null && media.getMediaUrl().contains(generatedName));

                    if (!exists) {
                        String imageUrl = uploadImageService.uploadImage(file, generatedName);

                        postMediaRepo.savePostMedia(PostMediaDto.builder()
                                .postId(dto.getId())
                                .mediaUrl(imageUrl)
                                .build());
                    }
                }
            }

            // Xoá ảnh không còn nằm trong danh sách file upload
            for (PostMediaDto media : currentMedias) {
                if (media.getMediaUrl() != null) {
                    String mediaFileName = media.getMediaUrl().substring(media.getMediaUrl().lastIndexOf("/") + 1);
                    if (!uploadedFileNames.contains(mediaFileName)) {
                        uploadImageService.deleteImage(media.getMediaUrl());
                        postMediaRepo.deletePostMedia(media.getId());
                    }
                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public PostDetailResponse getPostDetail(String id) {
        return null;
    }
}
