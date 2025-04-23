package entity.planet;


public class PlanetCRUDService {
    private PlanetDAO planetDao = new PlanetDAO();
    public void create(Planet planet){
        if(planet != null){
            planetDao.create(planet);
        }
    }

    public Planet read(String id){
        return planetDao.read(id);
    }

    public void update(Planet planet){
        if(planet !=null){
            planetDao.update(planet);
        }
    }

    public void delete(String id){
        planetDao.delete(id);
    }
}
