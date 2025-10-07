let socket = new SockJS('http://localhost:8080/ws-chat');
let stompClient = Stomp.over(socket);

let inputField = document.getElementById("name")


stompClient.connect({}, function() {
    console.log("Connected");

    stompClient.subscribe('/topic/messages/room1', function(message) {
        let messageObject = JSON.parse(message.body);

    let classToAdd = messageObject.username === inputField.value
        ? "message-sent"
        : "message-received";

    // Create message container
    let newMessage = document.createElement('div');
    newMessage.classList.add("message", classToAdd);

    // Add sender name
    let sender = document.createElement('div');
    sender.classList.add("sender-name");
    sender.textContent = messageObject.username;

    // Add message text
    let text = document.createElement('div');
    text.classList.add("message-text");
    text.textContent = messageObject.message;

    // Append both to message bubble
    newMessage.appendChild(sender);
    newMessage.appendChild(text);

    document.getElementById('message-section').appendChild(newMessage);
    });
});

function sendMessage() {
    let msg = document.getElementById('msg').value;
    stompClient.send("/app/sendMessage/room1", {username: inputField.value}, msg);
}