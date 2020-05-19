var myCursor = db.people.aggregate([
    { 
        $group: { 
            _id: "$sex",
            avgHeight: {$avg : { $toDouble: "$height" }},
            avgWeight: {$avg : { $toDouble: "$weight" }}
        }
    }
])

while (myCursor.hasNext()) {
   print(tojson(myCursor.next()));
}