db.people.mapReduce(
function () {
    for (i = 0; i < this.credit.length; i++) {
        emit(this.credit[i].currency, this.credit[i].balance * 1.0);
    }
}
,function (key, values) {
    cur = { balance: 0 , avg: 0};
    
    values.forEach(function(x) {
        cur.balance += x
    })

    cur.avg = Array.avg(values)
    return cur
}
,{ query: { sex: "Female", nationality: "Poland" }, out: "FemaleCashMR" })
.find({})