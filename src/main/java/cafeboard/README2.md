게시판 (Board) API
1. 게시판 생성
   HTTP Method: POST
   URI: /api/boards
   요청 본문:
   json
   코드 복사
   {
   "name": "게시판 이름"
   }
   응답 본문:
   json
   코드 복사
   {
   "id": 1,
   "name": "게시판 이름"
   }
2. 게시판 목록 조회
   HTTP Method: GET
   URI: /api/boards
   응답 본문:
   json
   코드 복사
   [
   {
   "id": 1,
   "name": "게시판 1"
   },
   {
   "id": 2,
   "name": "게시판 2"
   }
   ]
3. 게시판 수정
   HTTP Method: PUT
   URI: /api/boards/{boardId}
   요청 본문:
   json
   코드 복사
   {
   "name": "수정된 게시판 이름"
   }
   응답 본문:
   json
   코드 복사
   {
   "id": 1,
   "name": "수정된 게시판 이름"
   }
4. 게시판 삭제
   HTTP Method: DELETE
   URI: /api/boards/{boardId}
   응답 본문: 204 No Content (성공 시 응답 본문 없음)
   게시글 (Post) API
1. 게시글 생성
   HTTP Method: POST
   URI: /api/posts
   요청 본문:
   json
   코드 복사
   {
   "boardId": 1,
   "title": "게시글 제목",
   "content": "게시글 내용"
   }
   응답 본문:
   json
   코드 복사
   {
   "id": 1,
   "title": "게시글 제목",
   "content": "게시글 내용",
   "boardId": 1,
   "commentCount": 0
   }
2. 게시글 목록 조회
   HTTP Method: GET
   URI: /api/posts
   응답 본문:
   json
   코드 복사
   [
   {
   "id": 1,
   "title": "게시글 제목 1",
   "commentCount": 3
   },
   {
   "id": 2,
   "title": "게시글 제목 2",
   "commentCount": 5
   }
   ]
3. 게시글 상세 조회
   HTTP Method: GET
   URI: /api/posts/{postId}
   응답 본문:
   json
   코드 복사
   {
   "id": 1,
   "title": "게시글 제목 1",
   "content": "게시글 내용 1",
   "comments": [
   {
   "id": 1,
   "content": "댓글 내용 1"
   },
   {
   "id": 2,
   "content": "댓글 내용 2"
   }
   ]
   }
4. 게시글 수정
   HTTP Method: PUT
   URI: /api/posts/{postId}
   요청 본문:
   json
   코드 복사
   {
   "title": "수정된 제목",
   "content": "수정된 내용"
   }
   응답 본문:
   json
   코드 복사
   {
   "id": 1,
   "title": "수정된 제목",
   "content": "수정된 내용"
   }
5. 게시글 삭제
   HTTP Method: DELETE
   URI: /api/posts/{postId}
   응답 본문: 204 No Content (성공 시 응답 본문 없음)
   댓글 (Comment) API
1. 댓글 생성
   HTTP Method: POST
   URI: /api/posts/{postId}/comments
   요청 본문:
   json
   코드 복사
   {
   "content": "댓글 내용"
   }
   응답 본문:
   json
   코드 복사
   {
   "id": 1,
   "content": "댓글 내용",
   "postId": 1
   }
2. 댓글 수정
   HTTP Method: PUT
   URI: /api/comments/{commentId}
   요청 본문:
   json
   코드 복사
   {
   "content": "수정된 댓글 내용"
   }
   응답 본문:
   json
   코드 복사
   {
   "id": 1,
   "content": "수정된 댓글 내용",
   "postId": 1
   }
3. 댓글 삭제
   HTTP Method: DELETE
   URI: /api/comments/{commentId}
   응답 본문: 204 No Content (성공 시 응답 본문 없음)
   기타 기능 API
1. 특정 게시판의 게시글 목록 조회
   HTTP Method: GET
   URI: /api/boards/{boardId}/posts
   응답 본문:
   json
   코드 복사
   [
   {
   "id": 1,
   "title": "게시글 제목 1",
   "commentCount": 3
   },
   {
   "id": 2,
   "title": "게시글 제목 2",
   "commentCount": 5
   }
   ]
2. 특정 게시글의 댓글 목록 조회
   HTTP Method: GET
   URI: /api/posts/{postId}/comments
   응답 본문:
   json
   코드 복사
   [
   {
   "id": 1,
   "content": "댓글 내용 1"
   },
   {
   "id": 2,
   "content": "댓글 내용 2"
   }
   ]
