import { useQuery } from 'react-query';
import { QueryId } from '../common.types';
import { RestaurantService } from '../../services/RestaurantService';

export const useBrowseRestaurants = () => {
    return useQuery(QueryId.restaurants, RestaurantService.browse);
};
