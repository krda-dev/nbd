db.people.mapReduce(
function () {
    var bmi = (this.weight / (Math.pow(this.height,2))) * 10000
    
    emit(this.nationality, bmi );
}
, function (key, values) {
    cur = { myMin: 0, myMax: 0, myAvg: 0 }
    cur.myMin = values[0] //to jakos psuje, nie wiem dlaczego...
    
    values.forEach(function(x) {
        if (x > cur.myMax) {
            cur.myMax = x   
        }
        if (x < cur.myMin) {
            cur.myMin = x
        }
    })
    cur.myAvg = Array.avg(values)    
    return cur
}
, { out: "bmi"}).find({})
