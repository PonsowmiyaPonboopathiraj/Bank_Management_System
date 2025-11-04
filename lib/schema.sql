-- Bank Management System - PostgreSQL Schema + Seed Data (Fixed Version)

DROP TABLE IF EXISTS card, loan, loan_type, transaction, account, account_type, customer, employee, branch, users, role CASCADE;

-- ROLE
CREATE TABLE role (
  role_id     INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  role_name   VARCHAR(50) NOT NULL UNIQUE,
  description TEXT
);

-- CENTRALIZED USER TABLE
CREATE TABLE users (
  user_id     INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  email       VARCHAR(150) NOT NULL UNIQUE,
  password    VARCHAR(255) NOT NULL,
  role_id     INT NOT NULL REFERENCES role(role_id) ON DELETE RESTRICT,
  is_active   BOOLEAN DEFAULT TRUE,
  created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- BRANCH
CREATE TABLE branch (
  branch_id      INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  branch_name    VARCHAR(150) NOT NULL,
  ifsc_code      VARCHAR(20) NOT NULL UNIQUE,
  branch_address TEXT NOT NULL,
  branch_contact VARCHAR(20),
  manager_user_id INT REFERENCES users(user_id) ON DELETE SET NULL
);

-- EMPLOYEE (profile)
CREATE TABLE employee (
  employee_id   INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  user_id       INT NOT NULL UNIQUE REFERENCES users(user_id) ON DELETE CASCADE,
  full_name     VARCHAR(150) NOT NULL,
  phone         VARCHAR(20),
  branch_id     INT REFERENCES branch(branch_id) ON DELETE SET NULL,
  date_joined   DATE DEFAULT CURRENT_DATE,
  status        VARCHAR(20) DEFAULT 'Active'
);

-- CUSTOMER (profile)
CREATE TABLE customer (
  customer_id    INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  user_id        INT NOT NULL UNIQUE REFERENCES users(user_id) ON DELETE CASCADE,
  full_name      VARCHAR(150) NOT NULL,
  phone          VARCHAR(20),
  aadhaar_number VARCHAR(20) UNIQUE,
  pan_number     VARCHAR(20) UNIQUE,
  address        TEXT,
  date_of_birth  DATE,
  branch_id      INT REFERENCES branch(branch_id) ON DELETE SET NULL,
  status         VARCHAR(20) DEFAULT 'Active'
);

-- ACCOUNT TYPE
CREATE TABLE account_type (
  account_type_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  type_name       VARCHAR(50) NOT NULL UNIQUE,
  interest_rate   NUMERIC(5,2) NOT NULL DEFAULT 0.00,
  min_balance     NUMERIC(14,2) DEFAULT 0.00,
  description     TEXT
);

-- ACCOUNT
CREATE TABLE account (
  account_id      INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  account_number  VARCHAR(30) NOT NULL UNIQUE,
  customer_id     INT NOT NULL REFERENCES customer(customer_id) ON DELETE CASCADE,
  branch_id       INT REFERENCES branch(branch_id) ON DELETE SET NULL,
  account_type_id INT REFERENCES account_type(account_type_id) ON DELETE SET NULL,
  balance         NUMERIC(16,2) DEFAULT 0.00,
  created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  status          VARCHAR(20) DEFAULT 'Active'
);

-- TRANSACTION
CREATE TABLE transaction (
  transaction_id   BIGSERIAL PRIMARY KEY,
  account_id       INT NOT NULL REFERENCES account(account_id) ON DELETE CASCADE,
  transaction_type VARCHAR(30) NOT NULL,
  amount           NUMERIC(16,2) NOT NULL CHECK (amount >= 0),
  description      TEXT,
  transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  balance_after    NUMERIC(16,2),
  to_account       VARCHAR(30)
);

-- LOAN TYPE
CREATE TABLE loan_type (
  loan_type_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  loan_name    VARCHAR(100) NOT NULL UNIQUE,
  interest_rate NUMERIC(5,2) NOT NULL,
  max_amount   NUMERIC(16,2),
  max_tenure_months INT
);

-- LOAN
CREATE TABLE loan (
  loan_id        INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  customer_id    INT NOT NULL REFERENCES customer(customer_id) ON DELETE CASCADE,
  loan_type_id   INT NOT NULL REFERENCES loan_type(loan_type_id) ON DELETE SET NULL,
  principal_amount NUMERIC(16,2) NOT NULL,
  interest_rate  NUMERIC(5,2) NOT NULL,
  emi_amount     NUMERIC(16,2),
  tenure_months  INT NOT NULL,
  start_date     DATE DEFAULT CURRENT_DATE,
  end_date       DATE,
  status         VARCHAR(20) DEFAULT 'Pending',
  approved_by_user_id INT REFERENCES users(user_id) ON DELETE SET NULL
);

-- CARD
CREATE TABLE card (
  card_id      INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  account_id   INT NOT NULL REFERENCES account(account_id) ON DELETE CASCADE,
  card_number  VARCHAR(20) NOT NULL UNIQUE,
  card_type    VARCHAR(20) NOT NULL,
  cvv          VARCHAR(6) NOT NULL,
  expiry_date  DATE NOT NULL,
  issue_date   DATE DEFAULT CURRENT_DATE,
  status       VARCHAR(20) DEFAULT 'Active'
);

-- Indexes
CREATE INDEX idx_user_email ON users(email);
CREATE INDEX idx_account_number ON account(account_number);
CREATE INDEX idx_transaction_account ON transaction(account_id);
CREATE INDEX idx_customer_user ON customer(user_id);

-- Seed data
INSERT INTO role (role_name, description) VALUES
('Admin', 'System administrator with full privileges'),
('Employee', 'Bank employee with operational privileges'),
('Customer', 'Bank customer with account access');

INSERT INTO users (email, password, role_id, is_active) VALUES
('admin@gmail.com', 'admin123', 1, TRUE),
('kavya@gmail.com', 'kavya123', 2, TRUE),
('sowmiya@gmail.com', 'sowmiya123', 3, TRUE);

INSERT INTO branch(branch_name, ifsc_code, branch_address, branch_contact, manager_user_id) VALUES
('Central Branch', 'BANK0000001', '123 Main St, City', '0123456789', 1);

INSERT INTO employee(user_id, full_name, phone, branch_id) VALUES
(2, 'Kavya', '9876543210', 1);

INSERT INTO customer(user_id, full_name, phone, aadhaar_number, pan_number, address, date_of_birth, branch_id) VALUES
(3, 'Sowmiya', '9998887776', '123412341234', 'ABCDE1234F', '45, Park Lane, City', '1995-06-15', 1);

INSERT INTO account_type(type_name, interest_rate, min_balance, description) VALUES
('Savings', 3.50, 500.00, 'Regular savings account'),
('Current', 0.00, 0.00, 'Business current account'),
('Fixed Deposit', 6.50, 0.00, 'Fixed deposit');

INSERT INTO account(account_number, customer_id, branch_id, account_type_id, balance) VALUES
('ACC100000001', 1, 1, 1, 15000.00),
('ACC100000002', 1, 1, 3, 50000.00);

INSERT INTO transaction(account_id, transaction_type, amount, description, balance_after, to_account) VALUES
(1, 'Deposit', 15000.00, 'Initial deposit', 15000.00, NULL),
(2, 'Deposit', 50000.00, 'FD funding', 50000.00, NULL);

INSERT INTO loan_type(loan_name, interest_rate, max_amount, max_tenure_months) VALUES
('Home Loan', 7.50, 10000000.00, 360),
('Personal Loan', 12.00, 200000.00, 60);

INSERT INTO loan(customer_id, loan_type_id, principal_amount, interest_rate, emi_amount, tenure_months, start_date, end_date, status, approved_by_user_id) VALUES
(1, 2, 150000.00, 12.00, 3300.00, 60, '2025-01-01', '2030-01-01', 'Approved', 2);

INSERT INTO card(account_id, card_number, card_type, cvv, expiry_date, status) VALUES
(1, '4111111111111111', 'Debit', '123', '2028-12-31', 'Active');

CREATE VIEW view_account_summary AS
SELECT a.account_id, a.account_number, c.full_name AS customer_name, at.type_name AS account_type, a.balance, a.status, a.created_at
FROM account a
JOIN customer c ON a.customer_id = c.customer_id
LEFT JOIN account_type at ON a.account_type_id = at.account_type_id;
