package com.proj.olxshopv1;

import com.proj.olxshopv1.Entity.*;
import com.proj.olxshopv1.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Olxshopv1Application {
    public static final int numberOfCommodity=10;
    @Autowired
    CommodityRepository commodityRepository;
    public static void main(String[] args) {

         ConfigurableApplicationContext context =  SpringApplication.run(Olxshopv1Application.class, args);
        addUser(context);
        addCategories(context);
        addTypes(context);
        addSorts(context);
        addLocations(context);
        addDeveloper(context);

        addCommodity(context,numberOfCommodity);
        //addCertainCommodity(context);
    }
    @PostConstruct
    public void postCons() {
    }

    public static void addUser(ConfigurableApplicationContext context){
        UserRepository userRepository = context.getBean(UserRepository.class);
        UserEntity userEntity = new UserEntity();
        if(userRepository.count()==0) {
            userEntity.setName("oleg");
            userEntity.setPassword("oleg");
            userEntity.setEmail("oleg@gmail.com");
            userRepository.save(userEntity);
        }
    }
    public static void addCategories(ConfigurableApplicationContext context){
        List<String> categories = new ArrayList<>();
        categories.add("household appliances");
        categories.add("transport");
        categories.add("electronics");
        categories.add("building materials");
        categories.add("furniture");
        categories.add("detergents");
        categories.add("food");
        CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
        if(categoryRepository.count()==0){
            categories.forEach(c->{
            CategoryEntity categoryEntity = new CategoryEntity(c);
            categoryRepository.save(categoryEntity);
            });
        }
    }

    public static void addTypes(ConfigurableApplicationContext context){
        List<String> types = new ArrayList<>();
        types.add("refrigerator");
        types.add("smoothing iron");
        types.add("bicycle");
        types.add("scooter");
        types.add("phone");
        types.add("tv");
        types.add("paint");
        types.add("tile");
        types.add("bad");
        types.add("table");
        types.add("chlorine");
        types.add("rag");
        types.add("meat");
        types.add("grocery");
        TypeRepository typeRepository = context.getBean(TypeRepository.class);
        CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
        Random random = new Random();
        if(typeRepository.count()==0) {
            types.forEach(t->{
                CategoryEntity categoryEntity = new CategoryEntity();
                Long numb =Long.valueOf(random.nextInt((int)categoryRepository.count()-1)+1);
                categoryEntity.setId(numb);
                TypeEntity typeEntity = new TypeEntity(t,categoryEntity);
                typeRepository.save(typeEntity);
            });
        }
    }
    public static void addSorts(ConfigurableApplicationContext context){
        List<String> sorts = new ArrayList<>();
        sorts.add("xm8");
        sorts.add("ultimate 3000");
        sorts.add("update version 2");
        sorts.add("universal");
        sorts.add("v3");
        sorts.add("pro");
        sorts.add("version33");
        sorts.add("for children");
        sorts.add("black");
        sorts.add("extra large");
        sorts.add("pink version");
        SortRepository sortRepository = context.getBean(SortRepository.class);
        if(sortRepository.count()==0){
            sorts.forEach(s->{
                SortEntity sortEntity = new SortEntity(s);
                sortRepository.save(sortEntity);
            });
        }

    }


    public static void addLocations(ConfigurableApplicationContext context){
        List<LocationEntity> locations = new ArrayList<>();
        for (int i = 1; i <10 ; i++) {
            locations.add(new LocationEntity("Lviv"+i,"super street"+i,i,i));
        }
         LocationRepository locationRepository = context.getBean(LocationRepository.class);
        if(locationRepository.count()==0){
            locations.forEach(l->{
                locationRepository.save(l);
            });
        }
    }
    public static void addDeveloper(ConfigurableApplicationContext context){
        List<String> developers = new ArrayList<>();
        developers.add("bosh");
        developers.add("superVelik");
        developers.add("pineApple");
        developers.add("myPaint");
        developers.add("stil");
        developers.add("triapka");
        developers.add("nestle");
        DeveloperRepository developerRepository = context.getBean(DeveloperRepository.class);
        if(developerRepository.count()==0) {
            developers.forEach(d -> {
                DeveloperEntity developerEntity = new DeveloperEntity(d);
                developerRepository.save(developerEntity);
            });
        }
    }
    //////////////
    public static Long globalCount=0L;
    //////////////
    public static void addDescription(ConfigurableApplicationContext context){
        List<String> descriptions = new ArrayList<>();
      /*  descriptions.add("description 1");
        descriptions.add("description 2");
        descriptions.add("description 3");
        descriptions.add("description 4");
       */
        for (int i = 1; i <10 ; i++) {
            descriptions.add("description "+i);
        }
        DescriptionRepository descriptionRepository = context.getBean(DescriptionRepository.class);
       if(descriptionRepository.count()==0) {
           descriptions.forEach(d -> {
               DescriptionEntity descriptionEntity = new DescriptionEntity(d);
               descriptionRepository.save(descriptionEntity);
           });
       }
    }

    public static void addCommodity(ConfigurableApplicationContext context,int num){
        TypeRepository typeRepository = context.getBean(TypeRepository.class);
        SortRepository sortRepository = context.getBean(SortRepository.class);
        LocationRepository locationRepository = context.getBean(LocationRepository.class);
        DeveloperRepository developerRepository = context.getBean(DeveloperRepository.class);
        DescriptionRepository descriptionRepository = context.getBean(DescriptionRepository.class);
        CommodityRepository commodityRepository = context.getBean(CommodityRepository.class);

if(commodityRepository.count()==0) {
    List<String> pictures = new ArrayList<>();
    String way = "/img/product/";
    String format = ".jpg";
    pictures.add("bicycle");
    pictures.add("bad");
    pictures.add("tv");
    pictures.add("phone");
    pictures.add("table");
    pictures.add("tile");
    pictures.add("grocery");
    pictures.add("rag");
    pictures.add("paint");
    pictures.add("meat");
    pictures.add("scooter");
    pictures.add("smoothing iron");
    pictures.add("refrigerator");
    pictures.add("chlorine");
    Random random = new Random();
    for (int i = 0; i < num; i++) {
        String title =pictures.get(random.nextInt(pictures.size()));
        CommodityEntity commodityEntity = new CommodityEntity();
        commodityEntity.setCommodityTitle(title +" n"+ (i + 1));
        commodityEntity.setDateOfAdding((i + 1) + "/10/19");
        commodityEntity.setPicture(way+title+format);
        commodityEntity.setState("good");
        commodityEntity.setIdOfCommodity(1+i+34 + i);
        commodityEntity.setPrice(random.nextInt(500)+20);
        commodityEntity.setInStock(1);
        TypeEntity typeEntity = new TypeEntity();
        Long numb = Long.valueOf(random.nextInt((int) typeRepository.count() - 1) + 1);
        typeEntity.setId(numb);
        commodityEntity.setType(typeEntity);

        SortEntity sortEntity = new SortEntity();
        numb = Long.valueOf(random.nextInt((int) sortRepository.count() - 1) + 1);
        sortEntity.setId(numb);
        commodityEntity.setSort(sortEntity);

        LocationEntity locationEntity = new LocationEntity();
        numb = Long.valueOf(random.nextInt((int) locationRepository.count() - 1) + 1);
        locationEntity.setId(numb);
        commodityEntity.setLocation(locationEntity);

        DeveloperEntity developerEntity = new DeveloperEntity();
        numb = Long.valueOf(random.nextInt((int) developerRepository.count() - 1) + 1);
        developerEntity.setId(numb);
        commodityEntity.setDeveloper(developerEntity);

        DescriptionEntity descriptionEntity = new DescriptionEntity("Interesting and" +
                " marvelously great description of some product with super useful properties number " + i);
        descriptionRepository.save(descriptionEntity);
        descriptionEntity.setId(descriptionEntity.getId());
        commodityEntity.setDescription(descriptionEntity);

        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        commodityEntity.setUserSeller(userEntity);

        commodityRepository.save(commodityEntity);

    }

}
    }





    public static void addCertainCommodity(ConfigurableApplicationContext context) {
        TypeRepository typeRepository = context.getBean(TypeRepository.class);
        SortRepository sortRepository = context.getBean(SortRepository.class);
        LocationRepository locationRepository = context.getBean(LocationRepository.class);
        DeveloperRepository developerRepository = context.getBean(DeveloperRepository.class);
        DescriptionRepository descriptionRepository = context.getBean(DescriptionRepository.class);
        CommodityRepository commodityRepository = context.getBean(CommodityRepository.class);
        ////////////////////////
        DeveloperEntity developer = new DeveloperEntity();
        if(commodityRepository.count()==numberOfCommodity) {
            developer.setId(3L);
            TypeEntity type = new TypeEntity();
            type.setId(3L);
            SortEntity sort = new SortEntity();
            sort.setId(2L);
            LocationEntity location = new LocationEntity();
            location.setId(3L);
            DescriptionEntity description = new DescriptionEntity();
            description.setDescriptionContent("Raiden is that has a certain level of autonomy from a user and is programmed to clean. " +
                    "It uses vacuum to clean while It can also have additional methods like spinning brushes, mopping or UV sterilization.");
            descriptionRepository.save(description);
            UserEntity userEntity = new UserEntity();
            userEntity.setId(1L);
            CommodityEntity commodityEntity = new CommodityEntity("raiden", 1234, "/img/product/CyberRaiden.jpg", 1 + "/10/19", "good", 2000, 1,
                    description, developer, location, sort, type, userEntity);


            commodityEntity.setUserSeller(userEntity);
            commodityRepository.save(commodityEntity);
        }
    }
    }


