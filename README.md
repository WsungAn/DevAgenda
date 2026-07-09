## API 명세
### User API
회원 생성
| 항목     | 내용             |
| ------ | -------------- |
| URL    | `/users`       |
| Method | `POST`         |
| 설명     | 새로운 유저를 생성합니다. |

Request
| Field    | Type   | Required | Description |
| -------- | ------ | -------- | ----------- |
| username | String | O        | 유저명         |
| email    | String | O        | 이메일         |

Request Body
{
  "username": "kim",
  "email": "kim@test.com"
}

Response (201 Created)
{
  "id": 1,
  "username": "kim",
  "email": "kim@test.com",
  "createdAt": "2026-07-09T10:00:00",
  "modifiedAt": "2026-07-09T10:00:00"
}

전체 유저 조회
| 항목     | 내용            |
| ------ | ------------- |
| URL    | `/users`      |
| Method | `GET`         |
| 설명     | 전체 유저를 조회합니다. |


Response (200 OK)
[
  {
    "id": 1,
    "username": "kim",
    "email": "kim@test.com"
  },
  {
    "id": 2,
    "username": "lee",
    "email": "lee@test.com"
  }
]

단건 유저 조회
| 항목     | 내용                |
| ------ | ----------------- |
| URL    | `/users/{userId}` |
| Method | `GET`             |
| 설명     | 특정 유저를 조회합니다.     |

Path Variable
| Name   | Type | Description |
| ------ | ---- | ----------- |
| userId | Long | 유저 ID       |

Response (200 OK)
{
  "id": 1,
  "username": "kim",
  "email": "kim@test.com",
  "createdAt": "2026-07-09T10:00:00",
  "modifiedAt": "2026-07-09T10:00:00"
}

유저 수정
| 항목     | 내용                |
| ------ | ----------------- |
| URL    | `/users/{userId}` |
| Method | `PUT`             |
| 설명     | 유저 정보를 수정합니다.     |

Path Variable
| Name   | Type | Description |
| ------ | ---- | ----------- |
| userId | Long | 유저 ID       |

Request
| Field    | Type   | Required | Description |
| -------- | ------ | -------- | ----------- |
| username | String | O        | 변경할 유저명     |
| email    | String | O        | 변경할 이메일     |


{
  "username": "kim123",
  "email": "kim123@test.com"
}

Response (200 OK)
{
  "id": 1,
  "username": "kim123",
  "email": "kim123@test.com",
  "modifiedAt": "2026-07-09T10:30:00"
}

유저 삭제
| 항목     | 내용                |
| ------ | ----------------- |
| URL    | `/users/{userId}` |
| Method | `DELETE`          |
| 설명     | 유저를 삭제합니다.        |


Path Variable
| Name   | Type | Description |
| ------ | ---- | ----------- |
| userId | Long | 유저 ID       |


Response (200 OK)
{
  "message": "유저가 삭제되었습니다."
}

### Agenda API
일정 생성
| 항목     | 내용             |
| ------ | -------------- |
| URL    | `/agendas`     |
| Method | `POST`         |
| 설명     | 새로운 일정을 생성합니다. |

Request
| Field    | Type   | Required | Description |
| -------- | ------ | -------- | ----------- |
| userId   | Long   | O        | 작성자 ID      |
| title    | String | O        | 일정 제목       |
| contents | String | O        | 일정 내용       |


{
  "userId": 1,
  "title": "운동",
  "contents": "헬스장 가기"
}

Response (201 Created)
{
  "id": 1,
  "username": "kim",
  "title": "운동",
  "contents": "헬스장 가기",
  "createdAt": "2026-07-09T10:00:00",
  "modifiedAt": "2026-07-09T10:00:00"
}

전체 일정 조회
| 항목     | 내용            |
| ------ | ------------- |
| URL    | `/agendas`    |
| Method | `GET`         |
| 설명     | 전체 일정을 조회합니다. |


Response (200 OK)
[
  {
    "id": 1,
    "username": "kim",
    "title": "운동",
    "contents": "헬스장 가기"
  }
]

단건 일정 조회
| 항목     | 내용                    |
| ------ | --------------------- |
| URL    | `/agendas/{agendaId}` |
| Method | `GET`                 |
| 설명     | 특정 일정을 조회합니다.         |


Path Variable
| Name     | Type | Description |
| -------- | ---- | ----------- |
| agendaId | Long | 일정 ID       |


Response (200 OK)
{
  "id": 1,
  "username": "kim",
  "title": "운동",
  "contents": "헬스장 가기",
  "createdAt": "2026-07-09T10:00:00",
  "modifiedAt": "2026-07-09T10:00:00"
}

일정 수정
| 항목     | 내용                    |
| ------ | --------------------- |
| URL    | `/agendas/{agendaId}` |
| Method | `PUT`                 |
| 설명     | 일정을 수정합니다.            |


Path Variable
| Name     | Type | Description |
| -------- | ---- | ----------- |
| agendaId | Long | 일정 ID       |


Request
| Field    | Type   | Required | Description |
| -------- | ------ | -------- | ----------- |
| title    | String | O        | 일정 제목       |
| contents | String | O        | 일정 내용       |


{
  "title": "Spring 공부",
  "contents": "JPA 연관관계 복습"
}

Response (200 OK)
{
  "id": 1,
  "title": "Spring 공부",
  "contents": "JPA 연관관계 복습",
  "modifiedAt": "2026-07-09T11:00:00"
}

일정 삭제
| 항목     | 내용                    |
| ------ | --------------------- |
| URL    | `/agendas/{agendaId}` |
| Method | `DELETE`              |
| 설명     | 일정을 삭제합니다.            |


Path Variable
| Name     | Type | Description |
| -------- | ---- | ----------- |
| agendaId | Long | 일정 ID       |


Response (200 OK)
{
  "message": "일정이 삭제되었습니다."
}


<img width="177" height="519" alt="image" src="https://github.com/user-attachments/assets/5a4a71b4-159a-4cfd-8567-ae20fefd49e7" />

