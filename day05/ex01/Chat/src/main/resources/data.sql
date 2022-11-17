INSERT INTO chat.user(name, password) VALUES
('User1','user1'), ('User2','User2'), ('User3','User3'), ('User4','User4'), ('User5','User5'), ('User6','User6')
ON CONFLICT DO NOTHING;

INSERT INTO chat.chatroom(title, owner) VALUES
('Chat1', (SELECT id FROM chat.user WHERE name = 'User1')),
('Chat2', (SELECT id FROM chat.user WHERE name = 'User2')),
('Chat3', (SELECT id FROM chat.user WHERE name = 'User3')),
('Chat4', (SELECT id FROM chat.user WHERE name = 'User4')),
('Chat5', (SELECT id FROM chat.user WHERE name = 'User5')),
('Chat6', (SELECT id FROM chat.user WHERE name = 'User6'))
ON CONFLICT DO NOTHING;

INSERT INTO chat.message (author, room, text) VALUES
((SELECT id FROM chat.user WHERE name = 'User1'), (SELECT id FROM chat.chatroom WHERE title = 'Chat1'), 'Message1'),
((SELECT id FROM chat.user WHERE name = 'User2'), (SELECT id FROM chat.chatroom WHERE title = 'Chat2'), 'Message2'),
((SELECT id FROM chat.user WHERE name = 'User3'), (SELECT id FROM chat.chatroom WHERE title = 'Chat3'), 'Message3'),
((SELECT id FROM chat.user WHERE name = 'User4'), (SELECT id FROM chat.chatroom WHERE title = 'Chat4'), 'Message4'),
((SELECT id FROM chat.user WHERE name = 'User5'), (SELECT id FROM chat.chatroom WHERE title = 'Chat5'), 'Message5'),
((SELECT id FROM chat.user WHERE name = 'User6'), (SELECT id FROM chat.chatroom WHERE title = 'Chat6'), 'Message6')
ON CONFLICT DO NOTHING;

INSERT INTO chat.user_chatroom (user_id, chat_id) VALUES
((SELECT id FROM chat.user WHERE name = 'User1'), (SELECT id FROM chat.chatroom WHERE title = 'Chat1')),
((SELECT id FROM chat.user WHERE name = 'User2'), (SELECT id FROM chat.chatroom WHERE title = 'Chat2')),
((SELECT id FROM chat.user WHERE name = 'User3'), (SELECT id FROM chat.chatroom WHERE title = 'Chat3')),
((SELECT id FROM chat.user WHERE name = 'User4'), (SELECT id FROM chat.chatroom WHERE title = 'Chat4')),
((SELECT id FROM chat.user WHERE name = 'User5'), (SELECT id FROM chat.chatroom WHERE title = 'Chat5')),
((SELECT id FROM chat.user WHERE name = 'User6'), (SELECT id FROM chat.chatroom WHERE title = 'Chat6'))
ON CONFLICT DO NOTHING;
