const ROOT_URL = `http://localhost:8080/api/v1`; // replace this with graphql

export const RestaurantService = {
    browse: async () => {
        const restaurants = await fetch(`${ROOT_URL}/restaurants`);
        return restaurants.json();
    },
};
