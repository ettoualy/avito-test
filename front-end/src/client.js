const axios = require('axios')

const client = axios.create({
    baseURL: "http://localhost:8081", // This should be fetched from an env variable or something similar.
    headers: {
      'Content-Type': 'application/json',
    },
})

module.exports = client