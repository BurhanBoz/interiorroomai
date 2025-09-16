-- 1️⃣ DROP TABLES (önce foreign key bağımlılıklarını silmek için ters sırada)
DROP TABLE IF EXISTS feedback;
DROP TABLE IF EXISTS job_output;
DROP TABLE IF EXISTS job;
DROP TABLE IF EXISTS subscription;
DROP TABLE IF EXISTS user_credit;
DROP TABLE IF EXISTS plan;
DROP TABLE IF EXISTS user;

-- 2️⃣ CREATE TABLES

CREATE TABLE user (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
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
    features TEXT -- JSON string
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

CREATE TABLE job (
    job_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    plan_id BIGINT,
    style VARCHAR(50),
    status VARCHAR(50),
    created_at TIMESTAMP,
    credit_used INT,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (plan_id) REFERENCES plan(plan_id)
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

-- 3️⃣ INSERT SAMPLE DATA

-- USER
INSERT INTO user (user_id, email, password_hash, role, created_at, updated_at)
VALUES (1, 'demo1@example.com', 'hashedpass1', 'USER', NOW(), NOW()),
       (2, 'demo2@example.com', 'hashedpass2', 'USER', NOW(), NOW());

-- PLAN
INSERT INTO plan (plan_id, name, description, price, plan_type, credits, features)
VALUES (1, 'Basic', 'Stable Diffusion only', 9.99, 'CREDIT', 10, '["SD"]'),
       (2, 'Premium', 'SD + ControlNet + ESRGAN', 29.99, 'SUBSCRIPTION', 50, '["SD","ControlNet","ESRGAN"]');

-- USER_CREDIT
INSERT INTO user_credit (user_credit_id, user_id, plan_id, total_credits, remaining_credits, purchase_date)
VALUES (1, 1, 1, 10, 10, NOW()),
       (2, 2, 1, 10, 8, NOW());

-- SUBSCRIPTION
INSERT INTO subscription (subscription_id, user_id, plan_id, start_date, end_date, status, auto_renew)
VALUES (1, 1, 2, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 1 MONTH), 'ACTIVE', true),
       (2, 2, 2, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 1 MONTH), 'ACTIVE', false);

-- JOB
INSERT INTO job (job_id, user_id, plan_id, style, status, created_at, credit_used)
VALUES (1, 1, 1, 'VINTAGE', 'COMPLETED', NOW(), 1),
       (2, 2, 2, 'CLASSIC', 'PENDING', NOW(), 1);

-- JOB_OUTPUT
INSERT INTO job_output (output_id, job_id, image_url, quality_type, created_at)
VALUES (1, 1, 'https://example.com/vintage1.jpg', 'SD', NOW()),
       (2, 1, 'https://example.com/vintage2.jpg', 'ESRGAN', NOW());

-- FEEDBACK
INSERT INTO feedback (feedback_id, job_id, user_id, rating, comment, created_at)
VALUES (1, 1, 1, 5, 'Great result!', NOW()),
       (2, 1, 2, 4, 'Nice but needs more detail.', NOW());
