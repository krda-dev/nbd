var myself = { 
    "sex" : "Male", 
    "first_name" : "Krystian", 
    "last_name" : "Dajewski", 
    "job" : "Data Engineer", 
    "email" : "s21429@pjwstk.edu.pl", 
    "location" : {
        "city" : "Warsaw", 
        "address" : {
            "streetname" : "Sonaty", 
            "streetnumber" : "69"
        }
    }, 
    "description" : "to ja i kochane bazy danych", 
    "height" : "180.0", 
    "weight" : "80.5", 
    "birth_date" : "1995-07-16T07:22:24Z", 
    "nationality" : "Poland", 
    "credit" : [
        {
            "type" : "mastercard", 
            "number" : "56022141652043117", 
            "currency" : "PLN", 
            "balance" : "3843.63"
        }, 
        {
            "type" : "jcb", 
            "number" : "5600220902466171", 
            "currency" : "EU", 
            "balance" : "3870.48"
        }
    ]
}

db.people.insertOne(myself)