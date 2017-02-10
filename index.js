const sqlite3 = require("sqlite3");
const indexeddbjs = require('indexeddb-js');

var engine = new sqlite3.Database(':memory:');
var scope = indexeddbjs.makeScope('sqlite3', engine);
var request = scope.indexedDB.open('MyDatabase');

request.onupgradeneeded = function(event) {
    console.log(">>> UPGRADE NEEDED");
    var db = event.target.result;
    var store = db.createObjectStore('data', {keyPath: 'id'});
    store.createIndex('value', 'value', {unique: false});
    store.add({id: 1, value: "first-element"});
}

request.onsuccess = function(event) {
    console.log(">>> ON SUCCESS");
}

