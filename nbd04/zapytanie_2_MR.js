db.people.mapReduce(
    function() { 
        this.credit.forEach(function(x) {
            emit(x.currency, parseFloat(x.balance));
    });
    },
    function(key, values) {
        return Array.sum(values);
    },
    {
        query: {},
        out: "sumValues"
    }
).find()