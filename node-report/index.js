const { MongoClient } = require('mongodb');

async function run() {
  const uri = 'mongodb://localhost:27017';
  const client = new MongoClient(uri, { useNewUrlParser: true, useUnifiedTopology: true });

  try {
    await client.connect();
    console.log('Connected to MongoDB');

    const database = client.db('demoDB');
    const collection = database.collection('demoCollection');

    const doc = {
      name: 'Demo Document',
      description: 'This is a demo document inserted into MongoDB',
      createdAt: new Date()
    };

    const result = await collection.insertOne(doc);
    console.log(`New document inserted with _id: ${result.insertedId}`);
  } catch (err) {
    console.error(err);
  } finally {
    await client.close();
  }
}

run().catch(console.dir);