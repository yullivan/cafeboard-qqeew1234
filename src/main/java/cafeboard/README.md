## 게시판 생성
POST /boards
### Body 파라미터
```json
{
  "name": "[여성패션] 의류"
}
```

## 게시판 목록 조회 
GET /boards
### 응답 데이터
```json
[
  {
    "id": 1,
    "name": "[여성패션] 의류"
  },
  {
    "id": 2,
    "name": "[여성패션] 신발"
  }
]
```

## 게시판 수정
POST / board/{boardId}
- body 파라미터 



## 게시판 삭제
DELETE / board/ {boardId}
-  boardId

게시판 수정 PUT /api1/boards/{boardid}
게시판 삭제 DELETE /api1/boards/{boardid}

게시글 생성 POST /api/boards/{boardid}/posts

## 게시글 생성
Post /board/{boardId}/post/
## Body 파라미터
```json
[
  {
    "id" : 1,
    "title" : "게시글1",
    "content" : "게시글1내용어쩌구"
  }
  
]
```
## 게시글 목록 조회
GET /posts  
예: /posts?boardId=3  
### Query 파라미터
- boardId
### 응답 데이터
```json
[
  {
    "id": 1,
    "title" : "dddd",
    "commentCount" : 33
  }
]
```
게시글 조회 GET /api/boards/{boardid}/posts/{postsid}
게시글 수정 PUT /api/boards/{boardid}/posts/{postsid}

## 게시글 수정
POST /post/{postId}
## body 파라미터
- 

## 게시글 삭제
DELETE /post/{postId}



게시글 삭제 DELETE /api/boards/{boardid}/posts/{postsid}

댓글 생성 POST /api/boards/{boardid}/posts/{postsid}/comments

## 댓글 생성
POST /boards/{boardId}/posts/{postId}/comment
### body 파라미터
```json
[
  {
    "id" : 1,
    "postId" : 1,
    "comment" : "댓글댓글댓글"
  }
  
]
```

## 댓글 수정
POST /boards/{boardId}/posts/{postId}/comment/{commentId}
### body 파라미터

## 댓글 삭제
DELETE /boards/{boardId}/posts/{postId}/comment/{commentId}



댓글 조회 GET /api/boards/{boardid}/posts/{postsid}/comments/{commentid}
댓글 수정 PUT /api/boards/{boardid}/posts/{postsid}/comments/{commentid}
댓글 삭제 DELETE /api/boards/{boardid}/posts/{postsid}/comments/{commentid}
