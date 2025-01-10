게시판 생성 POST /api1/boards
게시판 조회 GET /api1/boards/{boardid}
게시판 수정 PUT /api1/boards/{boardid}
게시판 삭제 DELETE /api1/boards/{boardid}

게시글 생성 POST /api/boards/{boardid}/posts
게시글 조회 GET /api/boards/{boardid}/posts/{postsid}
게시글 수정 PUT /api/boards/{boardid}/posts/{postsid}
게시글 삭제 DELETE /api/boards/{boardid}/posts/{postsid}

댓글 생성 POST /api/boards/{boardid}/posts/{postsid}/comments
댓글 조회 GET /api/boards/{boardid}/posts/{postsid}/comments/{commentid}
댓글 수정 PUT /api/boards/{boardid}/posts/{postsid}/comments/{commentid}
댓글 삭제 DELETE /api/boards/{boardid}/posts/{postsid}/comments/{commentid}
