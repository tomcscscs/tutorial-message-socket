/**
 * 
 */
//WebSocket 연결 생성

const socket = new WebSocket("ws://" + location.host + "/server");

// 메시지 수신
socket.addEventListener("message", function(event) {
	console.log(event.data);
	switch (event.data) {
		case "newFeed":
			window.alert("새 피드가 추가되었습니다.");
			break;
		case "newNotice":
			window.alert("새 공지가 추가되었습니다.");
			break;
	}
});	