var c =db.people.find({weight:{$gte:"68",$lt:"71.5"}}); 
while(c.hasNext()) {
    printjson(c.next())
}