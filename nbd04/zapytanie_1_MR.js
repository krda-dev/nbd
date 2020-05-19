db.people.mapReduce(
    function() { emit(
        {sex:this.sex}, 
        { 
          avgHeights:parseFloat(this.height), 
          avgWeights:parseFloat(this.weight)
        });
    },
    function(key, values) {
        var result = {avgHeights:0, avgWeights:0};
        var count = 0;
        for(var i = 0; i < values.length; i++) {
            result.avgHeights += values[i].avgHeights
            result.avgWeights += values[i].avgWeights
            count++
        }  
        result.avgHeights = result.avgHeights / count
        result.avgWeights = result.avgWeights / count
        return result;
    },
    {
        query: {},
        out: "height&weight averages"
    }
).find()