var stompClient = null;

function connect() {
    var socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        // 订阅Broker
        stompClient.subscribe('/user/queue/chat', function (chat) {
            showGreeting(JSON.parse(chat.body));
        });
    });
}

function sendMsg() {
    // 发送消息
    stompClient.send("/app/chat", {},
        JSON.stringify({'content': $("#content").val(), 'to': $("#to").val()}));
}

function showGreeting(message) {
    $("#chatsContent").append("<div>" + message.from + ":" + message.content + "</div>");
}

$(function () {
    connect();
    $("#send").click(function () {
        sendMsg();
    })
});