CREATE TABLE `comments` (
    id CHAR(36) PRIMARY KEY,
    content TEXT NOT NULL,
    user_id CHAR(36) NOT NULL,
    post_id CHAR(36) NOT NULL,
    parent_id CHAR(36),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted ENUM('ACTIVE', 'DELETED') DEFAULT 'ACTIVE',

    FOREIGN KEY (parent_id) REFERENCES comments(id) ON DELETE SET NULL
);
