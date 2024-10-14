erDiagram
    PRODUCT {
        integer id PK
        varchar name
        integer price
        timestamp created_at
        timestamp updated_at
    }

    STOCK {
        integer id PK
        integer product_id FK
        integer quantity
        timestamp created_at
        timestamp updated_at
    }

    MEMBER {
        integer id PK
        integer uuid
        varchar name
        integer balance
        timestamp created_at
        timestamp updated_at
    }

    ORDER {
        integer id PK
        integer uuid
        integer total_price
        timestamp created_at
        timestamp updated_at 
    }

    ORDER_PRODUCT {
        integer id PK
        integer order_id FK
        integer product_id FK
        integer quantity 
        integer order_price
        timestamp created_at
        timestamp updated_at 
    }

    PAYMENT_HISTORY {
        integer id PK
        integer uuid 
        integer order_id FK
        integer amount 
        timestamp created_at
        timestamp updated_at 
    }

    ORDER ||--|| PAYMENT_HISTORY : has
    PRODUCT ||--|| STOCK : has
    ORDER ||--o{ PRODUCT : contains
    ORDER ||--o{ ORDER_PRODUCT : contains
    PRODUCT ||--o{ ORDER_PRODUCT : contains
