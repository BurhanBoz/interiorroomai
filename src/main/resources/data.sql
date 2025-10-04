-- 1️⃣ DROP TABLES (önce bağımlı olanları)
DROP TABLE IF EXISTS feedback;
DROP TABLE IF EXISTS job_output;
DROP TABLE IF EXISTS job;
DROP TABLE IF EXISTS subscription;
DROP TABLE IF EXISTS user_credit;
DROP TABLE IF EXISTS payment_history;
DROP TABLE IF EXISTS style_catalog;
DROP TABLE IF EXISTS plan;
DROP TABLE IF EXISTS users;

-- 2️⃣ CREATE TABLES

CREATE TABLE users (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL DEFAULT 'USER',
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE plan (
    plan_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10,2),
    plan_type VARCHAR(50) NOT NULL, -- CREDIT, SUBSCRIPTION
    credits INT,
    features TEXT
);

CREATE TABLE user_credit (
    user_credit_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    plan_id BIGINT,
    total_credits INT,
    remaining_credits INT,
    purchase_date TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (plan_id) REFERENCES plan(plan_id)
);

CREATE TABLE subscription (
    subscription_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    plan_id BIGINT,
    start_date DATE,
    end_date DATE,
    status VARCHAR(50),
    auto_renew BOOLEAN,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (plan_id) REFERENCES plan(plan_id)
);

CREATE TABLE style_catalog (
    style_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL,
    description TEXT,
    active BOOLEAN DEFAULT TRUE
);

CREATE TABLE job (
    job_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    plan_id BIGINT,
    style_id BIGINT,
    status VARCHAR(50),
    created_at TIMESTAMP,
    credit_used INT,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (plan_id) REFERENCES plan(plan_id),
    FOREIGN KEY (style_id) REFERENCES style_catalog(style_id)
);

CREATE TABLE job_output (
    output_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    job_id BIGINT,
    image_url VARCHAR(500),
    quality_type VARCHAR(50),
    created_at TIMESTAMP,
    FOREIGN KEY (job_id) REFERENCES job(job_id)
);

CREATE TABLE feedback (
    feedback_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    job_id BIGINT,
    user_id BIGINT,
    rating INT,
    comment TEXT,
    created_at TIMESTAMP,
    FOREIGN KEY (job_id) REFERENCES job(job_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);

CREATE TABLE payment_history (
    payment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    plan_id BIGINT,
    amount DECIMAL(10,2),
    currency VARCHAR(10),
    status VARCHAR(50),
    provider VARCHAR(50),
    transaction_ref VARCHAR(255),
    created_at TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (plan_id) REFERENCES plan(plan_id)
);

-- 3️⃣ SAMPLE DATA

-- USER
INSERT INTO users (user_name, password, role, created_at, updated_at)
VALUES ('demo1@example.com', 'hashedpass1', 'USER', NOW(), NOW()),
       ('demo2@example.com', 'hashedpass2', 'USER', NOW(), NOW());

-- PLAN
INSERT INTO plan (name, description, price, plan_type, credits, features)
VALUES ('Basic', 'Stable Diffusion only', 9.99, 'CREDIT', 10, '["SD"]'),
       ('Premium', 'SD + ControlNet + ESRGAN', 29.99, 'SUBSCRIPTION', 50, '["SD","ControlNet","ESRGAN"]');

-- USER_CREDIT
INSERT INTO user_credit (user_id, plan_id, total_credits, remaining_credits, purchase_date)
VALUES (1, 1, 10, 10, NOW()),
       (2, 1, 10, 8, NOW());

-- SUBSCRIPTION
INSERT INTO subscription (user_id, plan_id, start_date, end_date, status, auto_renew)
VALUES (1, 2, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 1 MONTH), 'ACTIVE', true),
       (2, 2, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 1 MONTH), 'ACTIVE', false);

-- STYLE_CATALOG
INSERT INTO style_catalog (name, description, active)
VALUES ('VINTAGE', 'Old-style decoration', true),
       ('CLASSIC', 'Classic elegant style', true),
       ('MODERN', 'Modern and minimal style', true);

-- JOB
INSERT INTO job (user_id, plan_id, style_id, status, created_at, credit_used)
VALUES (1, 1, 1, 'COMPLETED', NOW(), 1),
       (2, 2, 2, 'PENDING', NOW(), 1);

-- JOB_OUTPUT
INSERT INTO job_output (job_id, image_url, quality_type, created_at)
VALUES (1, 'https://example.com/vintage1.jpg', 'SD', NOW()),
       (1, 'https://example.com/vintage2.jpg', 'ESRGAN', NOW());

-- FEEDBACK
INSERT INTO feedback (job_id, user_id, rating, comment, created_at)
VALUES (1, 1, 5, 'Great result!', NOW()),
       (1, 2, 4, 'Nice but needs more detail.', NOW());

-- PAYMENT_HISTORY
INSERT INTO payment_history (user_id, plan_id, amount, currency, status, provider, transaction_ref, created_at)
VALUES (1, 1, 9.99, 'USD', 'SUCCESS', 'Stripe', 'TXN12345', NOW()),
       (2, 2, 29.99, 'USD', 'SUCCESS', 'Iyzico', 'TXN67890', NOW());
