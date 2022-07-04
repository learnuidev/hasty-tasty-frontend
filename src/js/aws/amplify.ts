import { Amplify } from 'aws-amplify';

export function configure (config) {
    return Amplify.configure(config);
}


export function configureUserPool(config) {
  return configure({
    Auth: config
  })
}

export function configureAppSync({ graphqlEndpoint, region, authenticationType }) {
  return configure({
    aws_appsync_graphqlEndpoint: graphqlEndpoint,
    aws_appsync_region: region,
    aws_appsync_authenticationType: authenticationType
  })
}
