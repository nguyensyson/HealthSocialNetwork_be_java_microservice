package com.sonns.infratructures.shared;

import com.sonns.business.dto.PostMediaDto;
import com.sonns.business.repo.PostMediaRepo;
import com.sonns.infratructures.mapper.PostMediaMapper;
import com.sonns.infratructures.model.MediaType;
import com.sonns.infratructures.model.PostMedia;
import com.sonns.infratructures.repository.PostMediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PostMediaRepoImpl implements PostMediaRepo {

    private final PostMediaRepository postMediaRepository;
    private final PostMediaMapper postMediaMapper;

    @Override
    public void savePostMedia(PostMediaDto dto) {
        PostMedia postMedia = postMediaMapper.toEntity(dto);
        postMedia.setMediaType(MediaType.image);
        postMediaRepository.save(postMedia);
    }
}
