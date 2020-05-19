db.people.aggregate([
    {
        $group: { 
            _id: "$nationality",
            max: { $max:
                { $divide: [
                    { $toDouble: "$weight"}, 
                    { $pow: [ 
                        { $divide: [{ $toDouble: "$height"}, 100] }, 2
                    ]}
                ]}
            }
            ,min: { $min:
                { $divide: [
                    { $toDouble: "$weight"}, 
                    { $pow: [ 
                        { $divide: [{ $toDouble: "$height"}, 100] }, 2
                    ]}
                ]}
            }
            ,avg: { $avg:
                { $divide: [
                    { $toDouble: "$weight"}, 
                    { $pow: [ 
                        { $divide: [{ $toDouble: "$height"}, 100] }, 2
                    ]}
                ]}
            }
        }
    }
]);