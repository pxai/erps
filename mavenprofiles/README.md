<!-- 
Please, add <profiles> content to your maven settings file.
$HOME/.m2/settings.xml 
We set 3 profiles: dev, preproduction and production 
To check active profiles, in a project folder we run 
mvn help:active-profiles 
Now in our pom.xml we can add profiles with their own properties 
like database settings 
--> 
<settings> 
  <activeProfiles>
    <activeProfile>production</activeProfile>
  </activeProfiles>
<profiles> 

    <profile> 
        <id>dev</id> 
        <properties> 
            <environment.type>dev</environment.type> 
        </properties> 
    </profile> 
    <profile> 
        <id>preproduction</id> 
        <properties> 
            <environment.type>preproduction</environment.type> 
        </properties> 
    </profile> 
    <profile> 
        <id>production</id> 
        <properties> 
            <environment.type>production</environment.type> 
        </properties> 
    </profile> 
</profiles> 
</settings> 