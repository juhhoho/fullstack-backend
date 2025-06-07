# Fullstack Backend API Server 
## 프로젝트 소개 - Snap Campus
이 프로젝트는 위치 기반 랜드마크 탐방 및 퀘스트 수행을 지원하는 백엔드 API 서버입니다. 사용자들은 GPS 기반으로 랜드마크를 탐방하고, AI 기반 이미지 유사도 분석을 통한 퀘스트를 수행하며, 랭킹 시스템을 통해 경쟁할 수 있습니다.

## 기술 스택
- Java 17
- Spring Boot 3.x
- Spring Security
- Spring Data JPA
- Redis
- AWS S3
- JWT
- WebClient
- Docker

## 프로젝트 구조
```
backend/
├── common/                   	# 공통 모듈
│   ├── api_payload/         	# API 요청-응답 표준화
│   │   ├── failure/         	# 에러 처리
│   │   ├── success/         	# 성공 응답
│   │   └── baseApiResponse.java 	# 기본 페이로드
│   │
│   └── config/              	# 전역 설정 및 인프라 구성
│       ├── CorsConfig.java   	# cors 정책 설정
│       ├── RedisConfig.java 	# redis 연결 및 캐시 설정
│       ├── S3Config.java 		# aws s3 클라이언트 설정
│       ├── SecurityConfig.java 	# 인증/인가 보안 설정
│       └── WebClient.java      	# 커스텀 http 클라이언트
│
├── domain/                  	# 도메인 계층
│   ├── user/                	# 사용자 도메인
│   │   ├── controller/      	# 요청 핸들러
│   │   ├── service/         	# 비즈니스 로직
│   │   ├── repository/      	# 데이터 액세스
│   │   ├── entity/          	# DB 모델
│   │   └── dto/             	# 데이터 전송 객체
│   │
│   ├── landmark/            	# 랜드마크 도메인
│   └── progress/            	# 퀘스트 진행도 도메인
│
└── external/                	# 외부 연동 모듈
    └── ai-server/            	# ai-server 연동
```

## 주요 기능
1. **GPS 기반 랜드마크 접근 판단**
   - 사용자의 실제 위치와 서버에 등록된 위경도를 비교하여 탐방 가능 여부 판별
   - 동적 위치 기반 서비스 제공

2. **캐릭터 상호작용 및 학교 정보 제공**
   - 캐릭터와의 대화를 통한 장소 정보 안내
   - 감성적 UX 강화

3. **AI 기반 퀘스트 수행**
   - 사진 촬영 기반 퀘스트 시스템
   - AI 서버를 통한 실시간 이미지 유사도 분석
   - 마이크로서비스 아키텍처 기반 AI 서버 분리

4. **랭킹 시스템**
   - 퀘스트 점수 기반 사용자 랭킹
   - 게이미피케이션 요소 통합

## API 문서

### 사용자 관련 API

#### 1. 회원가입
- **엔드포인트**: POST /api/register
- **요청 본문**:
```json
{
    "username": "사용자 identifier",
    "password": "사용자 password",
    "nickname": "사용자 nickname"
}
```
- **응답 본문**:
```json
{
    "isSuccess": true,
    "code": "201 CREATED",
    "message": "회원가입 성공",
    "response": null
}
```

#### 2. 로그인
- **엔드포인트**: POST /api/login
- **요청 본문**:
```json
{
    "username": "사용자 identifier",
    "password": "사용자 password"
}
```
- **응답 본문**:
```json
{
    "isSuccess": true,
    "code": "200 OK",
    "message": "로그인 성공",
    "response": {
        "userId": "사용자 고유 id",
        "nickname": "사용자 nickname"
    }
}
```

#### 3. 토큰 재발급
- **엔드포인트**: POST /api/reissue
- **요청 헤더**: access (현재 사용중인 만료된 접근 토큰)
- **요청 본문**:
```json
{
    "username": "사용자 identifier",
    "password": "사용자 password"
}
```
- **응답 본문**:
```json
{
    "isSuccess": true,
    "code": "200 OK",
    "message": "토큰 재발급 성공",
    "response": null
}
```

#### 4. 랭킹 조회
- **엔드포인트**: GET /api/rankings
- **요청 헤더**: access (현재 사용중인 인증 토큰)
- **응답 본문**:
```json
{
    "isSuccess": true,
    "code": "200 OK",
    "message": "랭킹 조회 성공",
    "response": {
        "myNickName": "사용자 nickname",
        "myTotalScore": "사용자 total score",
        "rankings": [
            {
                "nickname": "사용자 닉네임",
                "totalScore": "총 점수",
                "rank": "순위"
            }
        ]
    }
}
```

### 랜드마크 및 퀘스트 관련 API

#### 1. 진행 정보 조회
- **엔드포인트**: GET /api/progress/user/{user_id}?latitude={latitude}&longitude={longitude}
- **요청 헤더**: access (현재 사용중인 인증 토큰)
- **응답 본문**:
```json
{
    "isSuccess": true,
    "code": "200 OK",
    "message": "퀘스트 수행 완료",
    "response": {
        "progressList": [
            {
                "landmarkId": "랜드마크 ID",
                "landmarkName": "랜드마크 이름",
                "completedAt": "완료 시간",
                "score": "획득 점수"
            }
        ],
        "landmarkList": [
            {
                "landmarkId": "랜드마크 ID",
                "landmarkName": "랜드마크 이름",
                "latitude": "위도",
                "longitude": "경도",
                "distance": "현재 위치로부터의 거리",
                "isAccessible": "접근 가능 여부"
            }
        ]
    }
}
```

#### 2. 퀘스트 제출
- **엔드포인트**: POST /api/landmarks/{landmark_name}/quest
- **요청 헤더**: access (현재 사용중인 인증 토큰)
- **요청 본문**: multipart/form-data
  - stdImage: 기준 이미지 파일
  - clientImage: 클라이언트가 제출한 이미지 파일
- **응답 본문**:
```json
{
    "isSuccess": true,
    "code": "200 OK",
    "message": "퀘스트 수행 완료",
    "response": {
        "score": "퀘스트 수행 점수"
    }
}
```

#### 3. 이미지 업로드 presigned URL 요청
- **엔드포인트**: GET /api/presignedUrl/upload?imageName={image_name}
- **응답 본문**:
```json
{
    "isSuccess": true,
    "code": "200 OK",
    "message": "업로드용 url 발급 성공",
    "response": {
        "presignedUrl": "발급 받은 임시 업로드용 presigned url"
    }
}
```

#### 4. 이미지 업로드
- **엔드포인트**: PUT – presigned url 원본
- **요청 본문**: 업로드할 이미지 파일 자체
- **응답**: S3 업로드 응답 (성공 시 200 OK)

## 설치 및 실행 방법

### 사전 요구사항
- Java 17
- Docker
- Redis
- AWS S3 계정 및 접근 권한

### 실행 방법
1. 프로젝트 클론
```bash
git clone [repository-url]
cd fullstack-backend
```

2. 의존성 설치
```bash
./gradlew build
```

3. 애플리케이션 실행
```bash
./gradlew bootRun
```

## 보안 및 최적화
- JWT 기반 사용자 인증/인가
- AWS S3 Presigned URL을 통한 이미지 업로드
- Redis를 통한 캐싱
- 마이크로서비스 아키텍처를 통한 AI 서버 분리
