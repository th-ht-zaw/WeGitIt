public class Database {

    //The main print method
    public String printinformation(String tea) {
	String information = ""
	if (tea == "assam") {
	    information = "Assam Tea\nType: Black\n\n\tAssam tea has a lot of caffeine that will help keep you awake throughout the day making it a great tea to drink in the morning with your breakfast. It’s also good for cardiovascular health and digestive health.";
	    System.out.println(information);
	    return information;
	}
	if (tea == "chamomile") {
	    information = "Chamomile Tea\nType: Herbal\n\n\tChamomile tea is made from either Roman chamomile or German chamomile plants.\n\t Chamomile tea is great for relaxation and acts as a sedative. In other words, it will help you fall asleep. It is also a digestive aid and can help suppress nausea. It will also give you some relief if you are feeling congested.";
	    System.out.println(information);
	    return information;
	}
	if (tea == "darjeeling") {
	    information = "Darjeeling Tea\nType: Black\n\n\tDarjeeling tea is grown in the Himalayas. It comes from a plant called Camellia sinensis which originates from China.\n\tDarjeeling tea will help you stay awake due to the high caffeine content. Although there is less caffeine compared to coffee, the effect lasts longer. It will also boost your metabolism, aid in weight loss, and improve digestion. Darjeeling tea can also benefit cardiovascular health by lowering cholesterol levels.";
	    System.out.println(information);
	    return information;
	}
	if (tea == "keemun") {
	    information = "Keemun Tea:\nType: Black\n\n\tKeemun tea will aid in digestion, boost metabolism, and aid in weight loss. It will also improve circulation and reduce cholesterol level. This will reduce your risk for various heart/cardiovascular diseases. It can also be used as an alternative to coffee to help keep you awake and calm.";
	    System.out.println(information);
	    return information;
	}
	if (tea == "sencha") {
	    information = "Sencha Tea:\nType: Green\n\n\tSencha is a very popular variation of green tea from Japan. It is the same as Bancha tea but more expensive because it is of better quality.\n\tIt is a great choice if you just want to relax. It will also boost your metabolism, aiding in weight loss. An added bonus is that it strengthens the immune system.";
	    System.out.println(information);
	    return information;
	}
	if (tea == "silver_needle") {
	    information = "Silver Needle Tea:\nType: White\n\n\tAlso known as Bai Hao YinZheng, Silver Needle Tea is has a lot of caffeine. Many believe that white teas are generally low in caffeine, however Silver Needle Tea has the most caffeine out of all the white teas making it a great tea to drink to help you stay awake. Silver Needle tea will also aid in digestion and boost your metabolism. It will also aid in heart health and immune health.";
	    System.out.println(information);
	    return information;
	}
	if (tea == "matcha") {
	    information = "Matcha Tea:\nType: Green\n\n\tMatcha tea comes in the form of a powder which is why it is so concentrated. It benefits the immune system and can also be a form of skin care. Matcha tea is also great for anytime you just want some relaxation.";
	    System.out.println(information);
	    return information;
	}
	if (tea == "ginger") {
	    information = "Ginger Tea:\nType: Herbal\n\n\tGinger Tea is most commonly consumed to relieve nausea. However, it has many other benefits such as boosting your metabolism and immune system. In addition, it is also great for cardiovascular health. It will help strengthen your heart and improve blood circulation.";
	    System.out.println(information);
	    return information;
	}
	if (tea == "ginseng") {
	    information = "Ginseng Tea:\nType: Herbal\n\n\tGinseng tea is great for digestion and will also boost your metabolism. It is also beneficial to the skin, but you can also just drink some to relax.";
	    System.out.println(information);
	    return information;
	}
	if (tea == "peppermint") {
	    information = "Peppermint Tea:\nType: Herbal\n\n\tPeppermint tea is great for relaxation. It acts as a sedative so it will also help you fall asleep. It will also soothe any nausea, aid digestion, and boost your metabolism. An added bonus is that Peppermint tea will also boost your immune system.";
	    System.out.println(information);
	    return information;
	}
	if (tea == "bai_mudan") {
	    information = "Bai mudan Tea:\nType: White\n\n\t Also called White Peony tea, this tea is great for both heart and immune health. It can also help strengthen your bones.";
	    System.out.println(information);
	    return information;
	}
	if (tea == "water_sprite") {
	    information = "Water Sprite Tea:\nType: Oolong\n\n\tThis tea is great for relaxation without the drowsiness. In fact, it will even help keep you awake. This makes it great for any stressful allnighters you might need to pull. An added bonus are its benefits to immune and cardiovascular health.";
	    System.out.println(information);
	    return information;
	}
	if (tea == "high_mountain") {
	    information = "High Mountain Tea:\nType: Oolong\n\n\tThis tea is great for relaxation. It will also improve your heart and immune health.";
	    System.out.println(information);
	    return information;
	}
	if (tea == "puerh") {
	    information = "Puerh Tea:\nType: Puerh\n\n\tPuerh tea is a unique tea that many argue should get it’s own category. It is an aged tea from the Yunnan province in China that gets compressed into a brick. It will help you stay awake and aid in digestion. It also benefits the cardiovascular system. ";
	    System.out.println(information);
	    return information;
	}

	//If statements should be following this format
	//Will update what is within the Strings once research is done
	//Question: Do we want to make the method "void" and make it not return anything? 
    } 


} 
