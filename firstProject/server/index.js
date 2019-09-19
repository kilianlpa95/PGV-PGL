var express = require("express");
var bodyParser = require("body-parser");
var app = express();

app.use(bodyParser.urlencoded({extended: true}));

const showCars = (req, res) => {
    var send = req.body.stateq;
    if (send == "ford"){
        res.send({
            "cars": [
            { "name":"Ford", "models":[ "Fiesta", "Focus", "Mustang" ] }/*,
            { "name":"BMW", "models":[ "320", "X3", "X5" ] },
            { "name":"Fiat", "models":[ "500", "Panda" ] }*/
            ]
        }
        );
    } else if (send == "BMW"){
        res.send({
            "cars": [
            //{ "name":"Ford", "models":[ "Fiesta", "Focus", "Mustang" ] },
            { "name":"BMW", "models":[ "320", "X3", "X5" ] }//,
            //{ "name":"Fiat", "models":[ "500", "Panda" ] }
            ]
        }
        );
    } else if (send == "fiat"){
        res.send({
            "cars": [
            //{ "name":"Ford", "models":[ "Fiesta", "Focus", "Mustang" ] },
            //{ "name":"BMW", "models":[ "320", "X3", "X5" ] },
            { "name":"Fiat", "models":[ "500", "Panda" ] }
            ]
        }
        );
    } else if (send == "all"){
        res.send({
            "name":"John",
            "age":30,
            "cars": [
            { "name":"Ford", "models":[ "Fiesta", "Focus", "Mustang" ] },
            { "name":"BMW", "models":[ "320", "X3", "X5" ] },
            { "name":"Fiat", "models":[ "500", "Panda" ] }
            ]
        }
        );
    } else if (send == "obj"){
            res.send({"name":"John"});
        } else {
            console.log("bugabuga    ");
            res.send({"name":"muerto"})
            //res.send("Prueba valores como \"ford\", \"BMW\", \"fiat\" o \"all\". Object con \"obj\". Case sensitive. La key con \"state\"")
        }
    /*if (req.body != "state"){
        res.send("Detectado una key distinta a \"state\"");
    }*/
    //console.log(req.body);
};

app.get("/cars", showCars);

const port = 40000;

app.listen(port, () => {
    console.log("Running server on port: " + port);
});