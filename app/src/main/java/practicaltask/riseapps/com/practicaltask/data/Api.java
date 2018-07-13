package practicaltask.riseapps.com.practicaltask.data;

import java.util.List;

import io.reactivex.Observable;
import practicaltask.riseapps.com.practicaltask.data.model.Country;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("region")
    Observable<List<Country>> loadCountries(@Query("region") String region);
}
