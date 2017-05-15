package com.gaoyy.delivery4driver.api.bean;

import java.util.List;

/**
 * Created by gaoyy on 2017/5/11 0011.
 */

public class GeocodeInfo
{

    /**
     * results : [{"address_components":[{"long_name":"1552","short_name":"1552","types":["street_number"]},{"long_name":"Rue Baxter","short_name":"Rue Baxter","types":["route"]},{"long_name":"LaSalle","short_name":"LaSalle","types":["political","sublocality","sublocality_level_1"]},{"long_name":"Montréal","short_name":"Montréal","types":["locality","political"]},{"long_name":"Communauté-Urbaine-de-Montréal","short_name":"Communauté-Urbaine-de-Montréal","types":["administrative_area_level_2","political"]},{"long_name":"Québec","short_name":"QC","types":["administrative_area_level_1","political"]},{"long_name":"加拿大","short_name":"CA","types":["country","political"]},{"long_name":"H8N 2T5","short_name":"H8N 2T5","types":["postal_code"]}],"formatted_address":"1552 Rue Baxter, LaSalle, QC H8N 2T5加拿大","geometry":{"location":{"lat":45.438691,"lng":-73.6101765},"location_type":"ROOFTOP","viewport":{"northeast":{"lat":45.4400399802915,"lng":-73.6088275197085},"southwest":{"lat":45.4373420197085,"lng":-73.6115254802915}}},"partial_match":true,"place_id":"ChIJ_fHmWBkRyUwRBha-UxsgI5c","types":["street_address"]}]
     * status : OK
     */

    private String status;
    private List<ResultsBean> results;

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public List<ResultsBean> getResults()
    {
        return results;
    }

    public void setResults(List<ResultsBean> results)
    {
        this.results = results;
    }

    public static class ResultsBean
    {
        /**
         * address_components : [{"long_name":"1552","short_name":"1552","types":["street_number"]},{"long_name":"Rue Baxter","short_name":"Rue Baxter","types":["route"]},{"long_name":"LaSalle","short_name":"LaSalle","types":["political","sublocality","sublocality_level_1"]},{"long_name":"Montréal","short_name":"Montréal","types":["locality","political"]},{"long_name":"Communauté-Urbaine-de-Montréal","short_name":"Communauté-Urbaine-de-Montréal","types":["administrative_area_level_2","political"]},{"long_name":"Québec","short_name":"QC","types":["administrative_area_level_1","political"]},{"long_name":"加拿大","short_name":"CA","types":["country","political"]},{"long_name":"H8N 2T5","short_name":"H8N 2T5","types":["postal_code"]}]
         * formatted_address : 1552 Rue Baxter, LaSalle, QC H8N 2T5加拿大
         * geometry : {"location":{"lat":45.438691,"lng":-73.6101765},"location_type":"ROOFTOP","viewport":{"northeast":{"lat":45.4400399802915,"lng":-73.6088275197085},"southwest":{"lat":45.4373420197085,"lng":-73.6115254802915}}}
         * partial_match : true
         * place_id : ChIJ_fHmWBkRyUwRBha-UxsgI5c
         * types : ["street_address"]
         */

        private String formatted_address;
        private GeometryBean geometry;
        private boolean partial_match;
        private String place_id;
        private List<AddressComponentsBean> address_components;
        private List<String> types;

        public String getFormatted_address()
        {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address)
        {
            this.formatted_address = formatted_address;
        }

        public GeometryBean getGeometry()
        {
            return geometry;
        }

        public void setGeometry(GeometryBean geometry)
        {
            this.geometry = geometry;
        }

        public boolean isPartial_match()
        {
            return partial_match;
        }

        public void setPartial_match(boolean partial_match)
        {
            this.partial_match = partial_match;
        }

        public String getPlace_id()
        {
            return place_id;
        }

        public void setPlace_id(String place_id)
        {
            this.place_id = place_id;
        }

        public List<AddressComponentsBean> getAddress_components()
        {
            return address_components;
        }

        public void setAddress_components(List<AddressComponentsBean> address_components)
        {
            this.address_components = address_components;
        }

        public List<String> getTypes()
        {
            return types;
        }

        public void setTypes(List<String> types)
        {
            this.types = types;
        }

        public static class GeometryBean
        {
            /**
             * location : {"lat":45.438691,"lng":-73.6101765}
             * location_type : ROOFTOP
             * viewport : {"northeast":{"lat":45.4400399802915,"lng":-73.6088275197085},"southwest":{"lat":45.4373420197085,"lng":-73.6115254802915}}
             */

            private LocationBean location;
            private String location_type;
            private ViewportBean viewport;

            public LocationBean getLocation()
            {
                return location;
            }

            public void setLocation(LocationBean location)
            {
                this.location = location;
            }

            public String getLocation_type()
            {
                return location_type;
            }

            public void setLocation_type(String location_type)
            {
                this.location_type = location_type;
            }

            public ViewportBean getViewport()
            {
                return viewport;
            }

            public void setViewport(ViewportBean viewport)
            {
                this.viewport = viewport;
            }

            public static class LocationBean
            {
                /**
                 * lat : 45.438691
                 * lng : -73.6101765
                 */

                private double lat;
                private double lng;

                public double getLat()
                {
                    return lat;
                }

                public void setLat(double lat)
                {
                    this.lat = lat;
                }

                public double getLng()
                {
                    return lng;
                }

                public void setLng(double lng)
                {
                    this.lng = lng;
                }
            }

            public static class ViewportBean
            {
                /**
                 * northeast : {"lat":45.4400399802915,"lng":-73.6088275197085}
                 * southwest : {"lat":45.4373420197085,"lng":-73.6115254802915}
                 */

                private NortheastBean northeast;
                private SouthwestBean southwest;

                public NortheastBean getNortheast()
                {
                    return northeast;
                }

                public void setNortheast(NortheastBean northeast)
                {
                    this.northeast = northeast;
                }

                public SouthwestBean getSouthwest()
                {
                    return southwest;
                }

                public void setSouthwest(SouthwestBean southwest)
                {
                    this.southwest = southwest;
                }

                public static class NortheastBean
                {
                    /**
                     * lat : 45.4400399802915
                     * lng : -73.6088275197085
                     */

                    private double lat;
                    private double lng;

                    public double getLat()
                    {
                        return lat;
                    }

                    public void setLat(double lat)
                    {
                        this.lat = lat;
                    }

                    public double getLng()
                    {
                        return lng;
                    }

                    public void setLng(double lng)
                    {
                        this.lng = lng;
                    }
                }

                public static class SouthwestBean
                {
                    /**
                     * lat : 45.4373420197085
                     * lng : -73.6115254802915
                     */

                    private double lat;
                    private double lng;

                    public double getLat()
                    {
                        return lat;
                    }

                    public void setLat(double lat)
                    {
                        this.lat = lat;
                    }

                    public double getLng()
                    {
                        return lng;
                    }

                    public void setLng(double lng)
                    {
                        this.lng = lng;
                    }
                }
            }
        }

        public static class AddressComponentsBean
        {
            /**
             * long_name : 1552
             * short_name : 1552
             * types : ["street_number"]
             */

            private String long_name;
            private String short_name;
            private List<String> types;

            public String getLong_name()
            {
                return long_name;
            }

            public void setLong_name(String long_name)
            {
                this.long_name = long_name;
            }

            public String getShort_name()
            {
                return short_name;
            }

            public void setShort_name(String short_name)
            {
                this.short_name = short_name;
            }

            public List<String> getTypes()
            {
                return types;
            }

            public void setTypes(List<String> types)
            {
                this.types = types;
            }
        }
    }
}
