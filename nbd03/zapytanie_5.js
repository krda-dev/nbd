var ppl = db.people.find({"birth_date":{$gte:"2000-01-01T00:00:00Z"}},{"first_name":1,"last_name":1,"location.city":1, "_id":0})
while (ppl.hasNext()) {
     printjson(ppl.next())   
}
