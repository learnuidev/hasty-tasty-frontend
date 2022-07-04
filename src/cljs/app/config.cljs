(ns app.config)

(defonce env {:region "us-east-1"
              :userPoolId "us-east-1_juyEIUq4s"
              :userPoolWebClientId "4b0r08bsh5qbveq1bu69i77ekd"
              :mandatorySignIn true
              :graphqlEndpoint "https://hgw6zoyujzfq5argz3tclaysty.appsync-api.us-east-1.amazonaws.com/graphql"
              :authenticationType "AMAZON_COGNITO_USER_POOLS"})
