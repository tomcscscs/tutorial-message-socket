/**
 * 
 */
//WebSocket 연결 생성
const human = {
	name : "홍길동",
	age : 17
}
console.log(JSON.stringify(human));

const socket = new WebSocket("ws://" + location.host + "/server");

// 메시지 수신
socket.addEventListener("message", function(event) {
	console.log(event.data);
	const obj =JSON.parse(event.data);
	
	switch (obj.type) {
		case "newFeed":
			if(window.confirm(`새 피드가 추가되었습니다.\n[${obj.title}]를 바로 확인하시겠습니까?`)){
				location.href="/feed/"+obj.feedId;				
			}
			break;
		case "newNotice":
			window.alert("새 공지가 추가되었습니다.");
			break;
	}
});