import {Client} from "../../clients/shared/client.model";
import {Movie} from "../../movies/shared/movie.model";

export class Rental {
    id: number;
    movie: Movie;
    client: Client;
    date: string;
}
