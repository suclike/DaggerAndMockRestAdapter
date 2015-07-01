package ciriti.retrofitmockserver.api;

import com.google.gson.Gson;

import java.util.Collections;

import ciriti.retrofitmockserver.Constats;
import ciriti.retrofitmockserver.bean.RespBean;
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Query;
import retrofit.mime.TypedByteArray;

/**
 * Created by carmelo.iriti on 26/06/2015.
 */
public class MockService implements  ApiService{

    @Override
    public RespBean getUsers(@Query("pagesize") int numItems) {
        return new Gson().fromJson(DATA, RespBean.class);
    }

        @Override
        public void getUsers(@Query("pagesize") int numItems, Callback<RespBean> callback) {
                RespBean obj = new Gson().fromJson(DATA, RespBean.class);
                Response response = new Response(Constats.URL_ENDPOINT,
                        200,
                        "nothing",
                        Collections.EMPTY_LIST,
                        new TypedByteArray("application/json", DATA.getBytes()));
                callback.success(obj, response);
        }

        public static final String DATA = "{\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"badge_counts\": {\n" +
            "        \"bronze\": 100,\n" +
            "        \"silver\": 100,\n" +
            "        \"gold\": 100\n" +
            "      },\n" +
            "      \"account_id\": 10000,\n" +
            "      \"is_employee\": false,\n" +
            "      \"last_modified_date\": 1435175902,\n" +
            "      \"last_access_date\": 1435322729,\n" +
            "      \"age\": 30,\n" +
            "      \"reputation_change_year\": 1000,\n" +
            "      \"reputation_change_quarter\": 1000,\n" +
            "      \"reputation_change_month\": 1000,\n" +
            "      \"reputation_change_week\": 1000,\n" +
            "      \"reputation_change_day\": 1000,\n" +
            "      \"reputation\": 1000,\n" +
            "      \"creation_date\": 1222430705,\n" +
            "      \"user_type\": \"registered\",\n" +
            "      \"user_id\": 1000,\n" +
            "      \"accept_rate\": 1000,\n" +
            "      \"location\": \"Rome, Italy\",\n" +
            "      \"website_url\": \"http://google.com\",\n" +
            "      \"link\": 1000,\n" +
            "      \"profile_image\": \"http://blogs-images.forbes.com/thomasbrewster/files/2014/09/Android1.png\",\n" +
            "      \"display_name\": \"Fake User\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"has_more\": true,\n" +
            "  \"quota_max\": 300,\n" +
            "  \"quota_remaining\": 300\n" +
            "}";

    public static String DATA_100 = "\n" +
            "{\"items\":[{\"badge_counts\":{\"bronze\":6632,\"silver\":5422,\"gold\":364},\"account_id\":11683,\"is_employee\":false,\"last_modified_date\":1435704973,\"last_access_date\":1435747627,\"age\":39,\"reputation_change_year\":48999,\"reputation_change_quarter\":260,\"reputation_change_month\":260,\"reputation_change_week\":1040,\"reputation_change_day\":260,\"reputation\":788040,\"creation_date\":1222430705,\"user_type\":\"registered\",\"user_id\":22656,\"accept_rate\":86,\"location\":\"Reading, United Kingdom\",\"website_url\":\"http://csharpindepth.com\",\"link\":\"http://stackoverflow.com/users/22656/jon-skeet\",\"profile_image\":\"https://www.gravatar.com/avatar/6d8ebb117e8d83d74ea95fbdd0f87e13?s=128&d=identicon&r=PG\",\"display_name\":\"Jon Skeet\"},{\"badge_counts\":{\"bronze\":2072,\"silver\":2043,\"gold\":101},\"account_id\":14332,\"is_employee\":false,\"last_modified_date\":1435252308,\"last_access_date\":1435738248,\"age\":34,\"reputation_change_year\":36802,\"reputation_change_quarter\":158,\"reputation_change_month\":158,\"reputation_change_week\":696,\"reputation_change_day\":158,\"reputation\":597435,\"creation_date\":1224432467,\"user_type\":\"registered\",\"user_id\":29407,\"accept_rate\":88,\"location\":\"Sofia, Bulgaria\",\"website_url\":\"http://stackoverflow.com/search?q=user%3a29407&tab=newest\",\"link\":\"http://stackoverflow.com/users/29407/darin-dimitrov\",\"profile_image\":\"https://www.gravatar.com/avatar/e3a181e9cdd4757a8b416d93878770c5?s=128&d=identicon&r=PG\",\"display_name\":\"Darin Dimitrov\"},{\"badge_counts\":{\"bronze\":2186,\"silver\":1882,\"gold\":143},\"account_id\":52822,\"is_employee\":false,\"last_modified_date\":1435694582,\"last_access_date\":1435747951,\"age\":37,\"reputation_change_year\":44561,\"reputation_change_quarter\":205,\"reputation_change_month\":205,\"reputation_change_week\":1035,\"reputation_change_day\":205,\"reputation\":576425,\"creation_date\":1250527322,\"user_type\":\"registered\",\"user_id\":157882,\"accept_rate\":93,\"location\":\"Amsterdam, Netherlands\",\"website_url\":\"https://bauke-scholtz.zeef.com\",\"link\":\"http://stackoverflow.com/users/157882/balusc\",\"profile_image\":\"https://www.gravatar.com/avatar/89927e2f4bde24991649b353a37678b9?s=128&d=identicon&r=PG\",\"display_name\":\"BalusC\"},{\"badge_counts\":{\"bronze\":1246,\"silver\":661,\"gold\":61},\"account_id\":9266,\"is_employee\":false,\"last_modified_date\":1435704973,\"last_access_date\":1435747260,\"reputation_change_year\":44949,\"reputation_change_quarter\":140,\"reputation_change_month\":140,\"reputation_change_week\":894,\"reputation_change_day\":140,\"reputation\":556530,\"creation_date\":1221698729,\"user_type\":\"registered\",\"user_id\":17034,\"location\":\"Madison, WI\",\"link\":\"http://stackoverflow.com/users/17034/hans-passant\",\"profile_image\":\"http://i.stack.imgur.com/Cii6b.png?s=128&g=1\",\"display_name\":\"Hans Passant\"},{\"badge_counts\":{\"bronze\":1988,\"silver\":1477,\"gold\":115},\"account_id\":11975,\"is_employee\":true,\"last_modified_date\":1435719623,\"last_access_date\":1435742491,\"age\":36,\"reputation_change_year\":32898,\"reputation_change_quarter\":100,\"reputation_change_month\":100,\"reputation_change_week\":615,\"reputation_change_day\":100,\"reputation\":545787,\"creation_date\":1222667162,\"user_type\":\"moderator\",\"user_id\":23354,\"accept_rate\":100,\"location\":\"Forest of Dean, United Kingdom\",\"website_url\":\"http://blog.marcgravell.com\",\"link\":\"http://stackoverflow.com/users/23354/marc-gravell\",\"profile_image\":\"http://i.stack.imgur.com/NJcqr.png?s=128&g=1\",\"display_name\":\"Marc Gravell\"},{\"badge_counts\":{\"bronze\":1416,\"silver\":1323,\"gold\":122},\"account_id\":4243,\"is_employee\":false,\"last_modified_date\":1435730180,\"last_access_date\":1435747605,\"age\":44,\"reputation_change_year\":47521,\"reputation_change_quarter\":215,\"reputation_change_month\":215,\"reputation_change_week\":860,\"reputation_change_day\":215,\"reputation\":503206,\"creation_date\":1221344553,\"user_type\":\"registered\",\"user_id\":6309,\"accept_rate\":100,\"location\":\"France\",\"website_url\":\"http://careers.stackoverflow.com/vonc\",\"link\":\"http://stackoverflow.com/users/6309/vonc\",\"profile_image\":\"https://www.gravatar.com/avatar/7aa22372b695ed2b26052c340f9097eb?s=128&d=identicon&r=PG\",\"display_name\":\"VonC\"},{\"badge_counts\":{\"bronze\":1136,\"silver\":1076,\"gold\":50},\"account_id\":39846,\"is_employee\":false,\"last_modified_date\":1435720074,\"last_access_date\":1435748017,\"reputation_change_year\":46682,\"reputation_change_quarter\":215,\"reputation_change_month\":215,\"reputation_change_week\":950,\"reputation_change_day\":215,\"reputation\":479391,\"creation_date\":1243786808,\"user_type\":\"registered\",\"user_id\":115145,\"accept_rate\":86,\"location\":\"Over There\",\"website_url\":\"https://commonsware.com\",\"link\":\"http://stackoverflow.com/users/115145/commonsware\",\"profile_image\":\"https://www.gravatar.com/avatar/5ff53c2b4f6cc66ee989bb9d9effe119?s=128&d=identicon&r=PG\",\"display_name\":\"CommonsWare\"},{\"badge_counts\":{\"bronze\":1325,\"silver\":1091,\"gold\":71},\"account_id\":15988,\"is_employee\":false,\"last_modified_date\":1435236886,\"last_access_date\":1435709456,\"age\":24,\"reputation_change_year\":32872,\"reputation_change_quarter\":70,\"reputation_change_month\":70,\"reputation_change_week\":590,\"reputation_change_day\":70,\"reputation\":455278,\"creation_date\":1225829805,\"user_type\":\"registered\",\"user_id\":34397,\"accept_rate\":87,\"location\":\"New Jersey\",\"website_url\":\"http://SLaks.net\",\"link\":\"http://stackoverflow.com/users/34397/slaks\",\"profile_image\":\"https://www.gravatar.com/avatar/7deca8ec973c3c0875e9a36e1e3e2c44?s=128&d=identicon&r=PG\",\"display_name\":\"SLaks\"},{\"badge_counts\":{\"bronze\":957,\"silver\":758,\"gold\":89},\"account_id\":680,\"is_employee\":false,\"last_modified_date\":1435704973,\"last_access_date\":1435721121,\"age\":45,\"reputation_change_year\":34478,\"reputation_change_quarter\":183,\"reputation_change_month\":183,\"reputation_change_week\":728,\"reputation_change_day\":183,\"reputation\":422262,\"creation_date\":1218356820,\"user_type\":\"registered\",\"user_id\":893,\"accept_rate\":85,\"location\":\"Auckland, New Zealand\",\"website_url\":\"http://hewgill.com\",\"link\":\"http://stackoverflow.com/users/893/greg-hewgill\",\"profile_image\":\"https://www.gravatar.com/avatar/747ffa5da3538e66840ebc0548b8fd58?s=128&d=identicon&r=PG\",\"display_name\":\"Greg Hewgill\"},{\"badge_counts\":{\"bronze\":1233,\"silver\":782,\"gold\":92},\"account_id\":8291,\"is_employee\":false,\"last_modified_date\":1435422171,\"last_access_date\":1435737519,\"reputation_change_year\":35015,\"reputation_change_quarter\":95,\"reputation_change_month\":95,\"reputation_change_week\":511,\"reputation_change_day\":95,\"reputation\":407828,\"creation_date\":1221622605,\"user_type\":\"registered\",\"user_id\":14860,\"accept_rate\":98,\"website_url\":\"http://powerfield-software.com\",\"link\":\"http://stackoverflow.com/users/14860/paxdiablo\",\"profile_image\":\"http://i.stack.imgur.com/CXdfN.jpg?s=128&g=1\",\"display_name\":\"paxdiablo\"},{\"badge_counts\":{\"bronze\":1045,\"silver\":744,\"gold\":63},\"account_id\":34048,\"is_employee\":false,\"last_modified_date\":1434472068,\"last_access_date\":1435711865,\"age\":59,\"reputation_change_year\":38778,\"reputation_change_quarter\":140,\"reputation_change_month\":140,\"reputation_change_week\":598,\"reputation_change_day\":140,\"reputation\":396935,\"creation_date\":1240625354,\"user_type\":\"registered\",\"user_id\":95810,\"accept_rate\":80,\"location\":\"Sunnyvale, CA\",\"website_url\":\"http://www.aleax.it\",\"link\":\"http://stackoverflow.com/users/95810/alex-martelli\",\"profile_image\":\"https://www.gravatar.com/avatar/e8d5fe90f1fe2148bf130cccd4dc311c?s=128&d=identicon&r=PG\",\"display_name\":\"Alex Martelli\"},{\"badge_counts\":{\"bronze\":653,\"silver\":477,\"gold\":41},\"account_id\":10162,\"is_employee\":false,\"last_modified_date\":1435743728,\"last_access_date\":1435748212,\"reputation_change_year\":35084,\"reputation_change_quarter\":109,\"reputation_change_month\":109,\"reputation_change_week\":580,\"reputation_change_day\":109,\"reputation\":390181,\"creation_date\":1221842906,\"user_type\":\"registered\",\"user_id\":19068,\"location\":\"United Kingdom\",\"website_url\":\"http://dorward.me.uk\",\"link\":\"http://stackoverflow.com/users/19068/quentin\",\"profile_image\":\"https://www.gravatar.com/avatar/1d2d3229ed1961d2bd81853242493247?s=128&d=identicon&r=PG\",\"display_name\":\"Quentin\"},{\"badge_counts\":{\"bronze\":1127,\"silver\":802,\"gold\":70},\"account_id\":11948,\"is_employee\":false,\"last_modified_date\":1435704973,\"last_access_date\":1435589365,\"age\":34,\"reputation_change_year\":27310,\"reputation_change_quarter\":100,\"reputation_change_month\":100,\"reputation_change_week\":498,\"reputation_change_day\":100,\"reputation\":381887,\"creation_date\":1222642783,\"user_type\":\"registered\",\"user_id\":23283,\"accept_rate\":100,\"location\":\"Redmond, WA\",\"website_url\":\"http://blog.paranoidcoding.com/\",\"link\":\"http://stackoverflow.com/users/23283/jaredpar\",\"profile_image\":\"https://www.gravatar.com/avatar/529ba429a58902bef56c2fcb672d5ccb?s=128&d=identicon&r=PG\",\"display_name\":\"JaredPar\"},{\"badge_counts\":{\"bronze\":861,\"silver\":672,\"gold\":67},\"account_id\":7633,\"is_employee\":false,\"last_modified_date\":1435674602,\"last_access_date\":1435743089,\"age\":49,\"reputation_change_year\":29805,\"reputation_change_quarter\":100,\"reputation_change_month\":100,\"reputation_change_week\":580,\"reputation_change_day\":100,\"reputation\":376129,\"creation_date\":1221588555,\"user_type\":\"registered\",\"user_id\":13302,\"accept_rate\":93,\"location\":\"Bern, Switzerland\",\"website_url\":\"\",\"link\":\"http://stackoverflow.com/users/13302/marc-s\",\"profile_image\":\"https://www.gravatar.com/avatar/b4779212f57ff2e9549ea90a4499c2d7?s=128&d=identicon&r=PG\",\"display_name\":\"marc_s\"},{\"badge_counts\":{\"bronze\":929,\"silver\":742,\"gold\":36},\"account_id\":35417,\"is_employee\":false,\"last_modified_date\":1435744324,\"last_access_date\":1435746815,\"age\":42,\"reputation_change_year\":56333,\"reputation_change_quarter\":140,\"reputation_change_month\":140,\"reputation_change_week\":890,\"reputation_change_day\":140,\"reputation\":375246,\"creation_date\":1241362437,\"user_type\":\"moderator\",\"user_id\":100297,\"location\":\"Cambridge, United Kingdom\",\"website_url\":\"http://www.zopatista.com/\",\"link\":\"http://stackoverflow.com/users/100297/martijn-pieters\",\"profile_image\":\"https://www.gravatar.com/avatar/24780fb6df85a943c7aea0402c843737?s=128&d=identicon&r=PG\",\"display_name\":\"Martijn Pieters\"},{\"badge_counts\":{\"bronze\":715,\"silver\":673,\"gold\":100},\"account_id\":3748,\"is_employee\":false,\"last_modified_date\":1435155843,\"last_access_date\":1435359456,\"age\":30,\"reputation_change_year\":31318,\"reputation_change_quarter\":110,\"reputation_change_month\":110,\"reputation_change_week\":560,\"reputation_change_day\":110,\"reputation\":371651,\"creation_date\":1220976258,\"user_type\":\"registered\",\"user_id\":5445,\"location\":\"Guatemala\",\"website_url\":\"http://codingspot.com\",\"link\":\"http://stackoverflow.com/users/5445/cms\",\"profile_image\":\"https://www.gravatar.com/avatar/932fb89b9d4049cec5cba357bf0ae388?s=128&d=identicon&r=PG\",\"display_name\":\"CMS\"},{\"badge_counts\":{\"bronze\":609,\"silver\":320,\"gold\":47},\"account_id\":26521,\"is_employee\":false,\"last_modified_date\":1435746041,\"last_access_date\":1435745988,\"age\":44,\"reputation_change_year\":35845,\"reputation_change_quarter\":90,\"reputation_change_month\":90,\"reputation_change_week\":640,\"reputation_change_day\":90,\"reputation\":370577,\"creation_date\":1235161492,\"user_type\":\"registered\",\"user_id\":69083,\"location\":\"V&#228;sterv&#229;la, Sweden\",\"website_url\":\"http://www.guffa.com\",\"link\":\"http://stackoverflow.com/users/69083/guffa\",\"profile_image\":\"https://www.gravatar.com/avatar/1db0cdfd3fe268e270ec481a73046c2f?s=128&d=identicon&r=PG\",\"display_name\":\"Guffa\"},{\"badge_counts\":{\"bronze\":1060,\"silver\":882,\"gold\":65},\"account_id\":24377,\"is_employee\":false,\"last_modified_date\":1435115207,\"last_access_date\":1435746778,\"age\":35,\"reputation_change_year\":28560,\"reputation_change_quarter\":100,\"reputation_change_month\":100,\"reputation_change_week\":603,\"reputation_change_day\":100,\"reputation\":370013,\"creation_date\":1233672960,\"user_type\":\"registered\",\"user_id\":61974,\"location\":\"Denmark\",\"website_url\":\"http://careers.stackoverflow.com/markbyers/\",\"link\":\"http://stackoverflow.com/users/61974/mark-byers\",\"profile_image\":\"https://www.gravatar.com/avatar/ad240ed5cc406759f0fd72591dc8ca47?s=128&d=identicon&r=PG\",\"display_name\":\"Mark Byers\"},{\"badge_counts\":{\"bronze\":802,\"silver\":599,\"gold\":43},\"account_id\":10930,\"is_employee\":false,\"last_modified_date\":1435484470,\"last_access_date\":1435731530,\"reputation_change_year\":30642,\"reputation_change_quarter\":50,\"reputation_change_month\":50,\"reputation_change_week\":450,\"reputation_change_day\":50,\"reputation\":367008,\"creation_date\":1222135580,\"user_type\":\"registered\",\"user_id\":20862,\"accept_rate\":60,\"website_url\":\"\",\"link\":\"http://stackoverflow.com/users/20862/ignacio-vazquez-abrams\",\"profile_image\":\"https://www.gravatar.com/avatar/2343ae368d3241278581ce6c87f62a25?s=128&d=identicon&r=PG\",\"display_name\":\"Ignacio Vazquez-Abrams\"},{\"badge_counts\":{\"bronze\":676,\"silver\":540,\"gold\":50},\"account_id\":52616,\"is_employee\":false,\"last_modified_date\":1435704973,\"last_access_date\":1435746720,\"reputation_change_year\":45509,\"reputation_change_quarter\":215,\"reputation_change_month\":215,\"reputation_change_week\":1012,\"reputation_change_day\":215,\"reputation\":366234,\"creation_date\":1250420422,\"user_type\":\"registered\",\"user_id\":157247,\"accept_rate\":89,\"location\":\"United Kingdom\",\"website_url\":\"http://www.farsightsoftware.com\",\"link\":\"http://stackoverflow.com/users/157247/t-j-crowder\",\"profile_image\":\"https://www.gravatar.com/avatar/ca3e484c121268e4c8302616b2395eb9?s=128&d=identicon&r=PG\",\"display_name\":\"T.J. Crowder\"},{\"badge_counts\":{\"bronze\":912,\"silver\":907,\"gold\":60},\"account_id\":7598,\"is_employee\":true,\"last_modified_date\":1434381483,\"last_access_date\":1435704570,\"age\":30,\"reputation_change_year\":27090,\"reputation_change_quarter\":90,\"reputation_change_month\":90,\"reputation_change_week\":550,\"reputation_change_day\":90,\"reputation\":362246,\"creation_date\":1221587590,\"user_type\":\"moderator\",\"user_id\":13249,\"accept_rate\":100,\"location\":\"Winston-Salem, NC\",\"website_url\":\"http://nickcraver.com/blog/\",\"link\":\"http://stackoverflow.com/users/13249/nick-craver\",\"profile_image\":\"http://i.stack.imgur.com/nGCYr.jpg?s=128&g=1\",\"display_name\":\"Nick Craver\"},{\"badge_counts\":{\"bronze\":672,\"silver\":388,\"gold\":48},\"account_id\":8423,\"is_employee\":false,\"last_modified_date\":1435481445,\"last_access_date\":1435738635,\"age\":54,\"reputation_change_year\":31860,\"reputation_change_quarter\":120,\"reputation_change_month\":120,\"reputation_change_week\":599,\"reputation_change_day\":120,\"reputation\":360418,\"creation_date\":1221633947,\"user_type\":\"registered\",\"user_id\":15168,\"accept_rate\":100,\"location\":\"California, USA\",\"website_url\":\"http://None\",\"link\":\"http://stackoverflow.com/users/15168/jonathan-leffler\",\"profile_image\":\"https://www.gravatar.com/avatar/7d0d66b076e3bc70819e50f8a25af8df?s=128&d=identicon&r=PG\",\"display_name\":\"Jonathan Leffler\"},{\"badge_counts\":{\"bronze\":779,\"silver\":465,\"gold\":23},\"account_id\":237126,\"is_employee\":false,\"last_modified_date\":1435747040,\"last_access_date\":1435748088,\"age\":44,\"reputation_change_year\":35134,\"reputation_change_quarter\":55,\"reputation_change_month\":55,\"reputation_change_week\":648,\"reputation_change_day\":55,\"reputation\":356035,\"creation_date\":1251226343,\"user_type\":\"registered\",\"user_id\":505088,\"accept_rate\":91,\"location\":\"Ulverston, United Kingdom\",\"website_url\":\"\",\"link\":\"http://stackoverflow.com/users/505088/david-heffernan\",\"profile_image\":\"https://www.gravatar.com/avatar/3c0aac2191718ef0309dbc034d9b9961?s=128&d=identicon&r=PG\",\"display_name\":\"David Heffernan\"},{\"badge_counts\":{\"bronze\":1005,\"silver\":660,\"gold\":30},\"account_id\":25430,\"is_employee\":false,\"last_modified_date\":1435728314,\"last_access_date\":1435691408,\"age\":38,\"reputation_change_year\":18400,\"reputation_change_quarter\":50,\"reputation_change_month\":50,\"reputation_change_week\":248,\"reputation_change_day\":50,\"reputation\":349102,\"creation_date\":1234398071,\"user_type\":\"registered\",\"user_id\":65358,\"accept_rate\":76,\"location\":\"Bellingham, WA\",\"website_url\":\"http://www.reedcopsey.com\",\"link\":\"http://stackoverflow.com/users/65358/reed-copsey\",\"profile_image\":\"https://www.gravatar.com/avatar/87b3a4c585e6fd2ad5308e15e12bdc36?s=128&d=identicon&r=PG\",\"display_name\":\"Reed Copsey\"},{\"badge_counts\":{\"bronze\":1600,\"silver\":742,\"gold\":89},\"account_id\":32093,\"is_employee\":false,\"last_modified_date\":1435704973,\"last_access_date\":1435726865,\"age\":42,\"reputation_change_year\":26940,\"reputation_change_quarter\":50,\"reputation_change_month\":50,\"reputation_change_week\":458,\"reputation_change_day\":50,\"reputation\":347444,\"creation_date\":1239204526,\"user_type\":\"registered\",\"user_id\":88656,\"location\":\"Seattle, WA\",\"website_url\":\"http://ericlippert.com\",\"link\":\"http://stackoverflow.com/users/88656/eric-lippert\",\"profile_image\":\"https://www.gravatar.com/avatar/6fbdff3ffb6f111d172759b4f05bea0e?s=128&d=identicon&r=PG\",\"display_name\":\"Eric Lippert\"},{\"badge_counts\":{\"bronze\":595,\"silver\":333,\"gold\":29},\"account_id\":134022,\"is_employee\":false,\"last_modified_date\":1435704973,\"last_access_date\":1435730403,\"age\":44,\"reputation_change_year\":44335,\"reputation_change_quarter\":30,\"reputation_change_month\":30,\"reputation_change_week\":593,\"reputation_change_day\":30,\"reputation\":346431,\"creation_date\":1273269250,\"user_type\":\"registered\",\"user_id\":335858,\"accept_rate\":78,\"location\":\"United States\",\"website_url\":\"http://stackoverflow.com/users/335858/dasblinkenlight\",\"link\":\"http://stackoverflow.com/users/335858/dasblinkenlight\",\"profile_image\":\"https://www.gravatar.com/avatar/4af3541c00d591e9a518b9c0b3b1190a?s=128&d=identicon&r=PG\",\"display_name\":\"dasblinkenlight\"},{\"badge_counts\":{\"bronze\":836,\"silver\":699,\"gold\":104},\"account_id\":9867,\"is_employee\":false,\"last_modified_date\":1435726205,\"last_access_date\":1435712396,\"age\":42,\"reputation_change_year\":25661,\"reputation_change_quarter\":80,\"reputation_change_month\":80,\"reputation_change_week\":555,\"reputation_change_day\":80,\"reputation\":339960,\"creation_date\":1221783887,\"user_type\":\"registered\",\"user_id\":18393,\"accept_rate\":82,\"location\":\"New York, NY\",\"website_url\":\"http://www.cforcoding.com\",\"link\":\"http://stackoverflow.com/users/18393/cletus\",\"profile_image\":\"https://www.gravatar.com/avatar/2f364c2e36b52bc80296cbf23da8b231?s=128&d=identicon&r=PG\",\"display_name\":\"cletus\"},{\"badge_counts\":{\"bronze\":893,\"silver\":684,\"gold\":53},\"account_id\":26957,\"is_employee\":false,\"last_modified_date\":1433830554,\"last_access_date\":1359805964,\"age\":39,\"reputation_change_year\":24295,\"reputation_change_quarter\":100,\"reputation_change_month\":100,\"reputation_change_week\":438,\"reputation_change_day\":100,\"reputation\":336510,\"creation_date\":1235517707,\"user_type\":\"registered\",\"user_id\":70604,\"website_url\":\"http://pascal.thivent.name/\",\"link\":\"http://stackoverflow.com/users/70604/pascal-thivent\",\"profile_image\":\"https://www.gravatar.com/avatar/dc1a5b5fdba36ae9cdcf6e267f1a86ca?s=128&d=identicon&r=PG\",\"display_name\":\"Pascal Thivent\"},{\"badge_counts\":{\"bronze\":600,\"silver\":459,\"gold\":52},\"account_id\":21746,\"is_employee\":false,\"last_modified_date\":1435704973,\"last_access_date\":1435727027,\"age\":30,\"reputation_change_year\":26072,\"reputation_change_quarter\":90,\"reputation_change_month\":90,\"reputation_change_week\":510,\"reputation_change_day\":90,\"reputation\":324123,\"creation_date\":1231452721,\"user_type\":\"registered\",\"user_id\":53114,\"accept_rate\":45,\"location\":\"Ulm, Germany\",\"website_url\":\"http://careers.stackoverflow.com/markus-wulftange\",\"link\":\"http://stackoverflow.com/users/53114/gumbo\",\"profile_image\":\"https://www.gravatar.com/avatar/cd501083459cbc21fccae78e2d03bee2?s=128&d=identicon&r=PG\",\"display_name\":\"Gumbo\"},{\"badge_counts\":{\"bronze\":821,\"silver\":628,\"gold\":58},\"account_id\":70258,\"is_employee\":false,\"last_modified_date\":1435003298,\"last_access_date\":1435682253,\"age\":27,\"reputation_change_year\":25845,\"reputation_change_quarter\":70,\"reputation_change_month\":70,\"reputation_change_week\":505,\"reputation_change_day\":70,\"reputation\":318398,\"creation_date\":1257444683,\"user_type\":\"registered\",\"user_id\":203907,\"accept_rate\":81,\"location\":\"Sofia, Bulgaria\",\"website_url\":\"http://techblog.bozho.net\",\"link\":\"http://stackoverflow.com/users/203907/bozho\",\"profile_image\":\"https://www.gravatar.com/avatar/8de038497b6b8b67bc82eeaaef1a0b6b?s=128&d=identicon&r=PG\",\"display_name\":\"Bozho\"},{\"badge_counts\":{\"bronze\":474,\"silver\":293,\"gold\":20},\"account_id\":277416,\"is_employee\":false,\"last_modified_date\":1435731517,\"last_access_date\":1435732886,\"age\":39,\"reputation_change_year\":36119,\"reputation_change_quarter\":120,\"reputation_change_month\":120,\"reputation_change_week\":899,\"reputation_change_day\":120,\"reputation\":312169,\"creation_date\":1294757277,\"user_type\":\"registered\",\"user_id\":571407,\"accept_rate\":100,\"location\":\"Saint-Etienne, France\",\"website_url\":\"http://jnizet.free.fr\",\"link\":\"http://stackoverflow.com/users/571407/jb-nizet\",\"profile_image\":\"https://www.gravatar.com/avatar/2f0d9dec16bae1e06552af55ddefc11f?s=128&d=identicon&r=PG\",\"display_name\":\"JB Nizet\"},{\"badge_counts\":{\"bronze\":624,\"silver\":419,\"gold\":64},\"account_id\":10108,\"is_employee\":false,\"last_modified_date\":1434791471,\"last_access_date\":1435744978,\"age\":38,\"reputation_change_year\":22946,\"reputation_change_quarter\":80,\"reputation_change_month\":80,\"reputation_change_week\":450,\"reputation_change_day\":80,\"reputation\":311247,\"creation_date\":1221683246,\"user_type\":\"registered\",\"user_id\":18936,\"location\":\"Cambridge, UK\",\"website_url\":\"http://www.doxdesk.com/\",\"link\":\"http://stackoverflow.com/users/18936/bobince\",\"profile_image\":\"https://www.gravatar.com/avatar/3f6f1bea81a68b2f1cfe3efbb9be94bc?s=128&d=identicon&r=PG\",\"display_name\":\"bobince\"},{\"badge_counts\":{\"bronze\":587,\"silver\":280,\"gold\":25},\"account_id\":47283,\"is_employee\":false,\"last_modified_date\":1435581117,\"last_access_date\":1435730314,\"age\":58,\"reputation_change_year\":29523,\"reputation_change_quarter\":45,\"reputation_change_month\":45,\"reputation_change_week\":562,\"reputation_change_day\":45,\"reputation\":310082,\"creation_date\":1247815702,\"user_type\":\"registered\",\"user_id\":139985,\"accept_rate\":71,\"location\":\"Australia\",\"website_url\":\"https://espaces.edu.au/vwrangler\",\"link\":\"http://stackoverflow.com/users/139985/stephen-c\",\"profile_image\":\"https://www.gravatar.com/avatar/147c5a9cc1feec049c50da791ac7d144?s=128&d=identicon&r=PG\",\"display_name\":\"Stephen C\"},{\"badge_counts\":{\"bronze\":131,\"silver\":79,\"gold\":17},\"account_id\":1165580,\"is_employee\":false,\"last_modified_date\":1435726509,\"last_access_date\":1435719185,\"reputation_change_year\":59626,\"reputation_change_quarter\":165,\"reputation_change_month\":165,\"reputation_change_week\":993,\"reputation_change_day\":165,\"reputation\":307811,\"creation_date\":1326311637,\"user_type\":\"registered\",\"user_id\":1144035,\"location\":\"New York, United States\",\"website_url\":\"http://www.data-miners.com\",\"link\":\"http://stackoverflow.com/users/1144035/gordon-linoff\",\"profile_image\":\"https://www.gravatar.com/avatar/e514b017977ebf742a418cac697d8996?s=128&d=identicon&r=PG\",\"display_name\":\"Gordon Linoff\"},{\"badge_counts\":{\"bronze\":651,\"silver\":492,\"gold\":50},\"account_id\":7448,\"is_employee\":false,\"last_modified_date\":1435613440,\"last_access_date\":1435716807,\"age\":52,\"reputation_change_year\":18711,\"reputation_change_quarter\":20,\"reputation_change_month\":20,\"reputation_change_week\":278,\"reputation_change_day\":20,\"reputation\":302911,\"creation_date\":1221582134,\"user_type\":\"registered\",\"user_id\":12950,\"accept_rate\":95,\"location\":\"Iowa City, IA\",\"website_url\":\"http://farm-fresh-code.blogspot.com\",\"link\":\"http://stackoverflow.com/users/12950/tvanfosson\",\"profile_image\":\"https://www.gravatar.com/avatar/00aa1356e6f90fca08b36fb3c8d230c5?s=128&d=identicon&r=PG\",\"display_name\":\"tvanfosson\"},{\"badge_counts\":{\"bronze\":909,\"silver\":744,\"gold\":66},\"account_id\":37175,\"is_employee\":false,\"last_modified_date\":1435739599,\"last_access_date\":1435746343,\"age\":23,\"reputation_change_year\":32580,\"reputation_change_quarter\":80,\"reputation_change_month\":80,\"reputation_change_week\":655,\"reputation_change_day\":80,\"reputation\":301730,\"creation_date\":1242214829,\"user_type\":\"moderator\",\"user_id\":106224,\"accept_rate\":95,\"location\":\"Singapore\",\"website_url\":\"http://NOVALISTIC.com\",\"link\":\"http://stackoverflow.com/users/106224/boltclock\",\"profile_image\":\"https://www.gravatar.com/avatar/a2d818d801ce38a33807f68fdd92043a?s=128&d=identicon&r=PG\",\"display_name\":\"BoltClock\"},{\"badge_counts\":{\"bronze\":508,\"silver\":433,\"gold\":56},\"account_id\":76141,\"is_employee\":false,\"last_modified_date\":1435704973,\"last_access_date\":1435730922,\"age\":30,\"reputation_change_year\":33855,\"reputation_change_quarter\":135,\"reputation_change_month\":135,\"reputation_change_week\":630,\"reputation_change_day\":135,\"reputation\":301609,\"creation_date\":1259104089,\"user_type\":\"registered\",\"user_id\":218196,\"accept_rate\":100,\"location\":\"Sunnyvale, CA\",\"website_url\":\"http://felix-kling.de\",\"link\":\"http://stackoverflow.com/users/218196/felix-kling\",\"profile_image\":\"http://i.stack.imgur.com/4P5DY.jpg?s=128&g=1\",\"display_name\":\"Felix Kling\"},{\"badge_counts\":{\"bronze\":672,\"silver\":464,\"gold\":41},\"account_id\":1190,\"is_employee\":true,\"last_modified_date\":1435743163,\"last_access_date\":1435743599,\"age\":42,\"reputation_change_year\":15292,\"reputation_change_quarter\":111,\"reputation_change_month\":111,\"reputation_change_week\":331,\"reputation_change_day\":111,\"reputation\":298841,\"creation_date\":1218920052,\"user_type\":\"moderator\",\"user_id\":1583,\"accept_rate\":100,\"location\":\"London, United Kingdom\",\"website_url\":\"http://OdedCoster.com/blog\",\"link\":\"http://stackoverflow.com/users/1583/oded\",\"profile_image\":\"http://i.stack.imgur.com/Au4eT.png?s=128&g=1\",\"display_name\":\"Oded\"},{\"badge_counts\":{\"bronze\":504,\"silver\":413,\"gold\":43},\"account_id\":10375,\"is_employee\":false,\"last_modified_date\":1433343626,\"last_access_date\":1435746123,\"reputation_change_year\":29551,\"reputation_change_quarter\":200,\"reputation_change_month\":200,\"reputation_change_week\":700,\"reputation_change_day\":200,\"reputation\":296256,\"creation_date\":1221903545,\"user_type\":\"registered\",\"user_id\":19563,\"location\":\"United Kingdom\",\"website_url\":\"\",\"link\":\"http://stackoverflow.com/users/19563/charles-bailey\",\"profile_image\":\"https://www.gravatar.com/avatar/a8db27c91db97757a829c7971fd62b84?s=128&d=identicon&r=PG\",\"display_name\":\"Charles Bailey\"},{\"badge_counts\":{\"bronze\":963,\"silver\":592,\"gold\":58},\"account_id\":16029,\"is_employee\":false,\"last_modified_date\":1435329300,\"last_access_date\":1435747200,\"age\":29,\"reputation_change_year\":18591,\"reputation_change_quarter\":95,\"reputation_change_month\":95,\"reputation_change_week\":415,\"reputation_change_day\":95,\"reputation\":290217,\"creation_date\":1225845503,\"user_type\":\"registered\",\"user_id\":34509,\"accept_rate\":63,\"location\":\"Frankfurt, Germany\",\"website_url\":\"http://bloglitb.blogspot.com\",\"link\":\"http://stackoverflow.com/users/34509/johannes-schaub-litb\",\"profile_image\":\"http://i.stack.imgur.com/7FnYg.jpg?s=128&g=1\",\"display_name\":\"Johannes Schaub - litb\"},{\"badge_counts\":{\"bronze\":598,\"silver\":458,\"gold\":27},\"account_id\":64585,\"is_employee\":false,\"last_modified_date\":1435660606,\"last_access_date\":1435747680,\"reputation_change_year\":36745,\"reputation_change_quarter\":130,\"reputation_change_month\":130,\"reputation_change_week\":820,\"reputation_change_day\":130,\"reputation\":288358,\"creation_date\":1255610900,\"user_type\":\"registered\",\"user_id\":190597,\"accept_rate\":88,\"website_url\":\"\",\"link\":\"http://stackoverflow.com/users/190597/happyleapsecond\",\"profile_image\":\"https://www.gravatar.com/avatar/dd069899166bba0f0e53d3097452b00b?s=128&d=identicon&r=PG\",\"display_name\":\"HappyLeapSecond\"},{\"badge_counts\":{\"bronze\":611,\"silver\":279,\"gold\":27},\"account_id\":60200,\"is_employee\":false,\"last_modified_date\":1434407725,\"last_access_date\":1435696379,\"age\":50,\"reputation_change_year\":20705,\"reputation_change_quarter\":50,\"reputation_change_month\":50,\"reputation_change_week\":230,\"reputation_change_day\":50,\"reputation\":274059,\"creation_date\":1254094685,\"user_type\":\"registered\",\"user_id\":179910,\"location\":\"Colorado Springs, CO\",\"website_url\":\"http://coderscentral.blogspot.com/\",\"link\":\"http://stackoverflow.com/users/179910/jerry-coffin\",\"profile_image\":\"https://www.gravatar.com/avatar/d8962238339d771f0348967be6f97b1b?s=128&d=identicon&r=PG\",\"display_name\":\"Jerry Coffin\"},{\"badge_counts\":{\"bronze\":533,\"silver\":279,\"gold\":28},\"account_id\":23121,\"is_employee\":false,\"last_modified_date\":1435270047,\"last_access_date\":1435728584,\"reputation_change_year\":24696,\"reputation_change_quarter\":35,\"reputation_change_month\":35,\"reputation_change_week\":400,\"reputation_change_day\":35,\"reputation\":273205,\"creation_date\":1232573258,\"user_type\":\"registered\",\"user_id\":57695,\"accept_rate\":87,\"location\":\"Surrey, UK\",\"website_url\":\"http://vanillajava.blogspot.com/\",\"link\":\"http://stackoverflow.com/users/57695/peter-lawrey\",\"profile_image\":\"https://www.gravatar.com/avatar/53ee9941b3fefef67175daf212e62d41?s=128&d=identicon&r=PG\",\"display_name\":\"Peter Lawrey\"},{\"badge_counts\":{\"bronze\":820,\"silver\":595,\"gold\":79},\"account_id\":63368,\"is_employee\":false,\"last_modified_date\":1435692679,\"last_access_date\":1435741508,\"age\":35,\"reputation_change_year\":15448,\"reputation_change_quarter\":50,\"reputation_change_month\":50,\"reputation_change_week\":323,\"reputation_change_day\":50,\"reputation\":270691,\"creation_date\":1255170572,\"user_type\":\"registered\",\"user_id\":187606,\"accept_rate\":93,\"location\":\"Tabayesco, Lanzarote, Canary Islands\",\"website_url\":\"http://pgaiser.net\",\"link\":\"http://stackoverflow.com/users/187606/pekka-%ec%9b%83\",\"profile_image\":\"https://www.gravatar.com/avatar/100a6c42a31a56e882475725d65537f8?s=128&d=identicon&r=PG\",\"display_name\":\"Pekka ?\"},{\"badge_counts\":{\"bronze\":171,\"silver\":96,\"gold\":25},\"account_id\":262968,\"is_employee\":false,\"last_modified_date\":1435510476,\"last_access_date\":1435747947,\"reputation_change_year\":52034,\"reputation_change_quarter\":70,\"reputation_change_month\":70,\"reputation_change_week\":1040,\"reputation_change_day\":70,\"reputation\":269141,\"creation_date\":1292821840,\"user_type\":\"registered\",\"user_id\":548225,\"accept_rate\":90,\"location\":\"Bangalore, India\",\"website_url\":\"http://anubhava.wordpress.com\",\"link\":\"http://stackoverflow.com/users/548225/anubhava\",\"profile_image\":\"https://www.gravatar.com/avatar/dab08478b226280d4a30894c9a7ed719?s=128&d=identicon&r=PG\",\"display_name\":\"anubhava\"},{\"badge_counts\":{\"bronze\":742,\"silver\":654,\"gold\":48},\"account_id\":79153,\"is_employee\":false,\"last_modified_date\":1435221155,\"last_access_date\":1435746276,\"age\":27,\"reputation_change_year\":19644,\"reputation_change_quarter\":30,\"reputation_change_month\":30,\"reputation_change_week\":430,\"reputation_change_day\":30,\"reputation\":266515,\"creation_date\":1259924050,\"user_type\":\"registered\",\"user_id\":224671,\"accept_rate\":67,\"location\":\"Hong Kong\",\"website_url\":\"http://github.com/kennytm\",\"link\":\"http://stackoverflow.com/users/224671/kennytm\",\"profile_image\":\"https://www.gravatar.com/avatar/c90de868a7e95d75bdfd6a906dfedac7?s=128&d=identicon&r=PG\",\"display_name\":\"kennytm\"},{\"badge_counts\":{\"bronze\":814,\"silver\":562,\"gold\":61},\"account_id\":1475,\"is_employee\":false,\"last_modified_date\":1435575086,\"last_access_date\":1435746434,\"age\":30,\"reputation_change_year\":18306,\"reputation_change_quarter\":50,\"reputation_change_month\":50,\"reputation_change_week\":310,\"reputation_change_day\":50,\"reputation\":265577,\"creation_date\":1219161561,\"user_type\":\"registered\",\"user_id\":1968,\"accept_rate\":83,\"location\":\"Cambridge, United Kingdom\",\"website_url\":\"\",\"link\":\"http://stackoverflow.com/users/1968/konrad-rudolph\",\"profile_image\":\"https://www.gravatar.com/avatar/fdd630f72eef3790bfb4ef38d08c7f85?s=128&d=identicon&r=PG\",\"display_name\":\"Konrad Rudolph\"},{\"badge_counts\":{\"bronze\":372,\"silver\":290,\"gold\":16},\"account_id\":36572,\"is_employee\":false,\"last_modified_date\":1435735315,\"last_access_date\":1435748214,\"age\":42,\"reputation_change_year\":27494,\"reputation_change_quarter\":110,\"reputation_change_month\":110,\"reputation_change_week\":549,\"reputation_change_day\":110,\"reputation\":246984,\"creation_date\":1241958973,\"user_type\":\"registered\",\"user_id\":104349,\"accept_rate\":86,\"location\":\"London, United Kingdom\",\"website_url\":\"http://blog.roseman.org.uk\",\"link\":\"http://stackoverflow.com/users/104349/daniel-roseman\",\"profile_image\":\"https://www.gravatar.com/avatar/0f4cefeedec5163556751d61625eedd0?s=128&d=identicon&r=PG\",\"display_name\":\"Daniel Roseman\"},{\"badge_counts\":{\"bronze\":517,\"silver\":436,\"gold\":38},\"account_id\":180279,\"is_employee\":false,\"last_modified_date\":1433303615,\"last_access_date\":1435671981,\"age\":33,\"reputation_change_year\":16332,\"reputation_change_quarter\":50,\"reputation_change_month\":50,\"reputation_change_week\":340,\"reputation_change_day\":50,\"reputation\":246294,\"creation_date\":1281130778,\"user_type\":\"registered\",\"user_id\":413501,\"accept_rate\":87,\"location\":\"Potters Bar, United Kingdom\",\"website_url\":\"http://www.ladislavmrnka.com\",\"link\":\"http://stackoverflow.com/users/413501/ladislav-mrnka\",\"profile_image\":\"https://www.gravatar.com/avatar/f330cbdca0d0f3ca2328f9bd14d86afb?s=128&d=identicon&r=PG\",\"display_name\":\"Ladislav Mrnka\"},{\"badge_counts\":{\"bronze\":412,\"silver\":279,\"gold\":34},\"account_id\":378,\"is_employee\":false,\"last_modified_date\":1435746576,\"last_access_date\":1435745772,\"age\":32,\"reputation_change_year\":23034,\"reputation_change_quarter\":105,\"reputation_change_month\":105,\"reputation_change_week\":455,\"reputation_change_day\":105,\"reputation\":241806,\"creation_date\":1218010528,\"user_type\":\"registered\",\"user_id\":476,\"accept_rate\":69,\"location\":\"Germany\",\"website_url\":\"http://kunststube.net\",\"link\":\"http://stackoverflow.com/users/476/deceze\",\"profile_image\":\"https://www.gravatar.com/avatar/a235706e3d81b614acaec3368edfea4b?s=128&d=identicon&r=PG\",\"display_name\":\"deceze\"}],\"has_more\":true,\"quota_max\":300,\"quota_remaining\":293}";
}
