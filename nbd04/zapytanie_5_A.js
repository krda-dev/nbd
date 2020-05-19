printjson(db.people.aggregate([
    {
        $match: { $and: [{sex: "Female"}, {nationality: "Poland"}] }
    },
    {
        $unwind: "$credit"
    },
    {
        $group: {
            _id: "$credit.currency",
            sum: { $sum:  { $toDouble: "$credit.balance" }  },
            avg: { $avg: { $toDouble: "$credit.balance" }  }
        }
    },
    {
        $out: "FemaleCash"
    }
]).toArray())
