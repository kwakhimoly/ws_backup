package com.kosa.myapp3.comment.mine;

import java.util.List;

public interface CommentService {
public void insert(CommentDto dto);
public List<CommentDto> getList(CommentDto dto);
}
