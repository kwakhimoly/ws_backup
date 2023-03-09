package com.kosa.myapp3.comment.mine;

import java.util.List;

public interface CommentDao {
public void insert(CommentDto dto);
public List<CommentDto> getList(CommentDto dto);
}
