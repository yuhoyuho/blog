<h2> Basic Authentication </h2>

- 사용자 이름 / 비밀번호를 Base64로 인코딩하여 Authorization 헤더에 포함하여 전송
- 매우 안전하지 않음, SSL/TLS와 함께 사용됨

Authorization : Basic ~~~~~

<h2>Bearer Token Authentication > 사용 예정</h2>
- 헤더에 토큰을 포함하여 전송 Authorization 헤더에 포함하여 전송
- JWT를 사용하여 인증
- 간단한 방식, 상태를 유지하지 않음, 확장성이 높음
- 토큰 노출 위험, 토큰 관리

Authrization : Bearer ~~~~~

<h2>OAuth</h2>

- 토큰 기반 인증 방식, 사용자가 미리 인증을 받아서 토큰을 발급받음
- 이 토큰을 이용하여 API를 요청하는 방식 OAuth 2.0
- ex) kakao, meta, Git ..

-----
<h2>JWT (JSON Web Token)</h2>
- 클레임이라고 불리는 정보를 JSON 형태로 안전하게 전송하기 위한 토큰 기반의 표준
- 인증과 정보 교환에 사용, 서명이 되어 있어 신뢰성 확보 가능
- 장점 : 상태를 유지하지 않음(Stateless), 간단하고 자기 포함적, 확장성이 높다,
- 단점 : 클레임이 많을수록 크기가 커짐, 서명은 되어 있지만 암호화는 되어 있지 않음, 중요한 정보는 JWT에 포함하면 안됨
- 만료 시간, 갱신을 잘 해주어야 함