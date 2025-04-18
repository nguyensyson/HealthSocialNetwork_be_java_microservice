CREATE TABLE `reactions` (
    id CHAR(36) PRIMARY KEY,
    user_id CHAR(36) NOT NULL,
    post_id CHAR(36),
    comment_id CHAR(36),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted ENUM('ACTIVE', 'DELETED') DEFAULT 'ACTIVE',

    FOREIGN KEY (comment_id) REFERENCES comments(id) ON DELETE SET NULL
);
