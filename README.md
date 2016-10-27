# Mineplex Public API
Welcome to the Mineplex Public API! We provide [PC](#pc-api) and [PE](#pe-api) oriented endpoints for gathering information on players, network status, and more.

### General

All API endpoints utilize the HTTP `GET` method. Authorization & rate-limiting are handled via an [API key](#authorization).

The base URL for our API is [https://api.mineplex.com](https://api.mineplex.com).

PC/PE APIs are avaiable under the base at [/pc](https://api.mineplex.com/pc) and [/pe](https://api.mineplex.com/pe) respectively.

### Documentation
All documentation is written following the [OpenAPI 2.0 Specification](https://github.com/OAI/OpenAPI-Specification/blob/master/versions/2.0.md). 

**Contributing:**
Make changes to our docs here by submitting a pull request containing changes to the underlying data files. _Not the markdown files themself!_


For convenience you may also view the swagger-ui documentation for [PC](https://api.mineplex.com/pcdocs) and [PE](). (Provides an ineterface to interact with our API instead of just reading boring docs)


## PC API
The PC API is hosted at [https://api.mineplex.com/pc](https://api.mineplex.com/pc), and corresponds to the Mineplex Network on [Minecraft PC/Mac Edition](https://minecraft.net/). (us.mineplex.com/eu.mineplex.com)

### Authorization
We use API keys, similar to the majority of RESTful APIs, when authorizing your request. 

**Obtaining a key:**  
Each one of these keys is bound to a Minecraft account. As of now, you must be apart of the early access program to obtain a key; once we're out of that phase you'll be able to grab these in-game via `/api`.

**Using your key:**  
API keys are passed in through the `query` string `apiKey`. (we'll also be adding support for a request header to hold your key as well shortly)

**Note:** Please do not share your key with _anyone_. You will be held responsible for anything that happens from your key, so keep it in check!


### Caching
We implement server & client side caching for specific high traffic endpoints. Take note of the `Cache-Control` header for client sided caching.


### Rate Limiting
All keys have a starting limit of _3000 requests per hour_ (almost one request per second). We use the following HTTP headers to specify rate data in each request:

HTTP Header | Meaning
--- | ---
X-RateLimit-Limit | Your total requests allowed per hour
X-RateLimit-Remaining | The amount of requests you have remaining in this time period
X-RateLimit-Reset | The time at which your current rate limit period resets (in UTC epoch seconds)

If you have exceeded your rate limit, the API will respond with [HTTP 429 Too Many Requests](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes#429). 

Maybe what you're building makes a bit more requests than what we allow normally? Send an email our way including a brief explanation of what requires a slack on the rate-limiting.

## PE API
Soon™
