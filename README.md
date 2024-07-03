# Rent-Car

## Team
- Athallah Dwi Putro Ramadani
- Nabila Suci Syabani

### User Table
| Parameter | Type      | Description                |
|:----------|:----------|:---------------------------|
| `name`    | `string`  | **Required**. user name    |          |                            |
| `balance` | `integer` | **Required**. user balance |

### Input
#### Create User
```http
  POST /users   
```
```json
{
    "name" : "Naruto",
    "balance" : 5000
}
```
### Output
```json
{
    "id": 19,
    "name": "Naruto",
    "balance": 5000
}
```

### Input
#### Create User without name
```json
{
    "balance" : 5000
}
```

### Output
```json
{
    "status": "Bad Request",
    "message": "name cannot be blank",
    "data": null
}
```

### Input
#### Create User without balance
```json
{
    "name" : "Naruto"
}
```

### Output
```json
{
    "status": "Bad Request",
    "message": "balance cannot be null",
    "data": null
}
```

### Input
#### Get all Users
```http
  GET /users?page=1   
```
### Output
```Json
{
    "status": "OK",
    "message": "FOUND",
    "data": {
        "content": [
            {
                "id": 11,
                "name": "Kungfu Panda",
                "balance": 5000
            },
            {
                "id": 12,
                "name": "Piglet",
                "balance": 5000
            },
            {
                "id": 13,
                "name": "Tigre",
                "balance": 5000
            },
            {
                "id": 14,
                "name": "El",
                "balance": 5000
            },
            {
                "id": 15,
                "name": "Al",
                "balance": 5000
            },
            {
                "id": 16,
                "name": "Dul",
                "balance": 5000
            },
            {
                "id": 17,
                "name": "Poho",
                "balance": 5000
            },
            {
                "id": 18,
                "name": "Monyet",
                "balance": 5000
            }
        ],
        "totalElements": 18,
        "totalPages": 2,
        "page": 1,
        "size": 10
    }
}
```

### Input
#### Get By ID
```http
  GET /users/9  
```
### Output
```json
{
    "status": "OK",
    "message": "FOUND USER BY ID",
    "data": {
        "id": 9,
        "name": "Tingkir",
        "balance": 5000
    }
}
```

### Input
#### Update
```http
  PUT /users/update 
```
```json
{
  "id" : 1,
  "name" : "Wanda Maximoff",
  "balance" : 6000000
}
```

### Output
```json
{
  "id": 1,
  "name": "Wanda Maximoff",
  "balance": 6000000
}
```

### Input
#### Top Up
```http
  PUT /topup/5   
```
```json
{
    "balance" : 1495000
}
```
### Output
```json
{
    "id": 5,
    "name": "Natasha",
    "balance": 3920000
}
```


### Input
#### Delete
```http
  DELETE /users/9 
```
### Output (When Get By ID)
```json
{
  "status": "Bad Request",
  "message": "User not found",
  "data": null
}
```

### Brand Table
| Parameter | Type      | Description              |
|:----------|:----------|:-------------------------|
| `name`    | `string`  | **Required**. brand name |

### Input
#### Create Brand
```http
  POST /brands   
```
```json
{
  "name" : "Chevrolet"
}
```
### Output
```json
{
  "id": 6,
  "name": "Chevrolet"
}
```

### Input
#### Get all Brands
```http
  GET /brands?size=6 
```
### Output
```Json
{
  "status": "OK",
  "message": "FOUND",
  "data": {
    "content": [
      {
        "id": 1,
        "name": "Honda"
      },
      {
        "id": 2,
        "name": "Toyota"
      },
      {
        "id": 3,
        "name": "Hyundai"
      },
      {
        "id": 4,
        "name": "Wulling"
      },
      {
        "id": 5,
        "name": ""
      },
      {
        "id": 6,
        "name": "Chevrolet"
      }
    ],
    "totalElements": 6,
    "totalPages": 1,
    "page": 0,
    "size": 6
  }
}
```

### Input
#### Get By ID
```http
  GET /brands/6
```
### Output
```json
{
  "id": 6,
  "name": "Chevrolet"
}
```

### Input
#### Update
```http
  PUT /brands/update 
```
```json
{
  "id" : 5,
  "name" : "KIA"
}
```
### Output
```json
{
  "id": 5,
  "name": "KIA"
}
```

### Input
#### Delete
```http
  DELETE /brands/6
```
### Output (When Get By ID)
```json
{
  "status": "Bad Request",
  "message": "Brand not found",
  "data": null
}
```

### Car Table
| Parameter   | Type      | Description                 |
|:------------|:----------|:----------------------------|
| `name`      | `string`  | **Required**. car name      |
| `available` | `boolean` | **Required**. car available |
| `price`     | `integer` | **Required**. car price     |
| `brand`     | `brand`   | **Required**. car brand     |

### Input
#### Create Car
```http
  POST /cars   
```
```json
{
  "name": "Agya",
  "available": true,
  "price": 50000,
  "brand_id": 2
}
```
### Output
```json
{
  "id": 10,
  "name": "Agya",
  "available": true,
  "price": 50000,
  "brand": {
    "id": 2,
    "name": "Toyota"
  }
}
```
### Input
#### Get all Cars
```http
  GET /cars?available=true
```
### Output
```Json
{
  "status": "OK",
  "message": "FOUND",
  "data": {
    "content": [
      {
        "id": 2,
        "name": "Rush",
        "available": true,
        "price": 250000,
        "brand": {
          "id": 2,
          "name": "Toyota"
        }
      },
      {
        "id": 3,
        "name": "Jazz Skibidi",
        "available": true,
        "price": 200000,
        "brand": {
          "id": 1,
          "name": "Honda"
        }
      },
      {
        "id": 5,
        "name": "Creta",
        "available": true,
        "price": 175000,
        "brand": {
          "id": 3,
          "name": "Hyundai"
        }
      },
      {
        "id": 6,
        "name": "Ioniq 6",
        "available": true,
        "price": 275000,
        "brand": {
          "id": 3,
          "name": "Hyundai"
        }
      },
      {
        "id": 7,
        "name": "Air Ev",
        "available": true,
        "price": 115000,
        "brand": {
          "id": 4,
          "name": "Wulling"
        }
      },
      {
        "id": 8,
        "name": "Confero",
        "available": true,
        "price": 185000,
        "brand": {
          "id": 4,
          "name": "Wulling"
        }
      },
      {
        "id": 1,
        "name": "Jazz",
        "available": true,
        "price": 200000,
        "brand": {
          "id": 1,
          "name": "Honda"
        }
      },
      {
        "id": 9,
        "name": null,
        "available": true,
        "price": 185000,
        "brand": {
          "id": 4,
          "name": "Wulling"
        }
      },
      {
        "id": 10,
        "name": "Agya",
        "available": true,
        "price": 50000,
        "brand": {
          "id": 2,
          "name": "Toyota"
        }
      }
    ],
    "totalElements": 9,
    "totalPages": 1,
    "page": 0,
    "size": 10
  }
}
```

### Input
#### Get By ID
```http
  GET /cars/10
```
### Output
```json
{
  "id": 10,
  "name": "Agya",
  "available": true,
  "price": 50000,
  "brand": {
    "id": 2,
    "name": "Toyota"
  }
}
```

### Input
#### Update
```http
  PUT /cars/update/2
```
```json
{
  "name" : "Rush",
  "available" : true,
  "price" : 250000,
  "brand_id" : 2
}
```
### Output
```json
{
  "id": 2,
  "name": "Rush",
  "available": true,
  "price": 250000,
  "brand": {
    "id": 2,
    "name": "Toyota"
  }
}
```

### Input
#### Delete
```http
  DELETE /cars/4
```
### Output (When Get By ID)
```json
{
  "status": "Bad Request",
  "message": "Car not found",
  "data": null
}
```
### Rent Table
| Parameter      | Type      | Description           |
|:---------------|:----------|:----------------------|
| `completed`    | `boolean` | rent completed status |
| `started date` | `date`    | started date rent     |
| `ends date`    | `date`    | end date rent         |
| `price`        | `integer` | price rent            |
| `car id`       | `integer` | car id                |
| `user id`      | `integer` | user id               |

### Input
#### Create Rent
```http
  POST /rents 
```
```json
{
  "completed" : false,
  "started_at" : "2024-06-12",
  "ends_at" : "2024-06-17",
  "car_id" : 10,
  "user_id" : 6
}
```
### Output
```json
{
  "id": 7,
  "completed": false,
  "started_at": "2024-06-12",
  "ends_at": "2024-06-17",
  "price": 250000,
  "car": {
    "id": 10,
    "name": "Agya",
    "available": false,
    "price": 50000,
    "brand": {
      "id": 2,
      "name": "Toyota"
    }
  },
  "user": {
    "id": 6,
    "name": null,
    "balance": 3500000
  }
}
```

### Input
#### Get all Rents
```http
  GET /rents
```
### Output
```Json
{
  "status": "OK",
  "message": "FOUND",
  "data": {
    "content": [
      {
        "id": 1,
        "completed": false,
        "started_at": "2024-06-12",
        "ends_at": "2024-06-16",
        "price": 800000,
        "car": {
          "id": 1,
          "name": "Jazz",
          "available": true,
          "price": 200000,
          "brand": {
            "id": 1,
            "name": "Honda"
          }
        },
        "user": {
          "id": 1,
          "name": "Wanda Maximoff",
          "balance": 6000000
        }
      },
      {
        "id": 2,
        "completed": true,
        "started_at": "2024-07-02",
        "ends_at": "2024-07-09",
        "price": 1400000,
        "car": {
          "id": 1,
          "name": "Jazz",
          "available": true,
          "price": 200000,
          "brand": {
            "id": 1,
            "name": "Honda"
          }
        },
        "user": {
          "id": 2,
          "name": "Peter Parker",
          "balance": 600000
        }
      },
      {
        "id": 3,
        "completed": true,
        "started_at": "2024-07-12",
        "ends_at": "2024-07-17",
        "price": 1375000,
        "car": {
          "id": 6,
          "name": "Ioniq 6",
          "available": true,
          "price": 275000,
          "brand": {
            "id": 3,
            "name": "Hyundai"
          }
        },
        "user": {
          "id": 4,
          "name": "Loki",
          "balance": 2222500
        }
      },
      {
        "id": 4,
        "completed": true,
        "started_at": "2024-07-12",
        "ends_at": "2024-07-17",
        "price": 575000,
        "car": {
          "id": 7,
          "name": "Air Ev",
          "available": true,
          "price": 115000,
          "brand": {
            "id": 4,
            "name": "Wulling"
          }
        },
        "user": {
          "id": 5,
          "name": "Natasha",
          "balance": 3920000
        }
      },
      {
        "id": 7,
        "completed": false,
        "started_at": "2024-06-12",
        "ends_at": "2024-06-17",
        "price": 250000,
        "car": {
          "id": 10,
          "name": "Agya",
          "available": false,
          "price": 50000,
          "brand": {
            "id": 2,
            "name": "Toyota"
          }
        },
        "user": {
          "id": 6,
          "name": null,
          "balance": 3500000
        }
      }
    ],
    "totalElements": 5,
    "totalPages": 1,
    "page": 0,
    "size": 10
  }
}
```

### Input
#### Get By ID
```http
  GET /rents/2
```
### Output
```json
{
  "id": 2,
  "completed": true,
  "started_at": "2024-07-02",
  "ends_at": "2024-07-09",
  "price": 1400000,
  "car": {
    "id": 1,
    "name": "Jazz",
    "available": true,
    "price": 200000,
    "brand": {
      "id": 1,
      "name": "Honda"
    }
  },
  "user": {
    "id": 2,
    "name": "Peter Parker",
    "balance": 600000
  }
}
```

### Input
#### Update
```http
  PUT /rents/update/2
```
```json
{
  "completed" : false,
  "started_at" : "2024-06-12",
  "ends_at" : "2024-06-13",
  "car_id" : 2,
  "user_id" : 1
}
```
### Output
```json
{
  "id": 2,
  "completed": true,
  "started_at": "2024-06-12",
  "ends_at": "2024-06-13",
  "price": 250000,
  "car": {
    "id": 2,
    "name": "Rush",
    "available": false,
    "price": 250000,
    "brand": {
      "id": 2,
      "name": "Toyota"
    }
  },
  "user": {
    "id": 1,
    "name": "Wanda Maximoff",
    "balance": 6000000
  }
}
```

### Input
#### Delete
```http
  DELETE /rents/2
```
### Output (When Get By ID)
```json
{
  "status": "Bad Request",
  "message": "Rent not found",
  "data": null
}
```

### Input
#### Returned
```http
  PUT /rents/return
```
```json
{
  "id" : 1,
  "return_at" : "2024-06-20"
}
```
### Output (Late return, get penalty, car availability become true, rent completed true, user balance deducted according to rental payment and penalty)
```json
{
  "id": 1,
  "completed": true,
  "started_at": "2024-06-12",
  "ends_at": "2024-06-16",
  "price": 800000,
  "car": {
    "id": 1,
    "name": "Jazz",
    "available": true,
    "price": 200000,
    "brand": {
      "id": 1,
      "name": "Honda"
    }
  },
  "user": {
    "id": 1,
    "name": "Wanda Maximoff",
    "balance": 4080000
  }
}
```