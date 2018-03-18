// connect to mongo remotely
// mongo --host 52.191.118.86 --port 27017 -u sgsuser -p 'RF1Dkings' --authenticationDatabase 'admin'

// declare database
use savper_beta

// create database user owner
db.createUser(
    {
      user: "savper",
      pwd: "f1lejack",
      roles: [
         { role: "dbOwner", db: "savper_beta" }
      ]
    }
);

// create dependency collections, the rest will be created by Spring on CoreServices startup
db.createCollection("uploads");