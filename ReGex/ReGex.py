import re


def main():
    eventRegex = r'\s*\n*-{50,}\s*\n*'
    placeRegex = r'(?i)(?:place|yer|location|mekan)\s*:\s+(.*?)\s*?[\n\r]'
    dateRegex = r'(?i)(?:date|tarih|deadline)\s*:\s+(.*?)\s*?[\n\r]'
    timeRegex = r'(?i)(?:time|zaman)\s*:\s+(.*?)\s*?[\n\r]'
    
    testData = getTestData()

    for i in range(len(testData)):
        events = re.split(eventRegex, testData[i])
        for j, event in enumerate(events):
            eventPlace = re.findall(placeRegex, event)
            eventDate = re.findall(dateRegex, event)
            eventTime = re.findall(timeRegex, event)
            file = open("results/" + str(i) + "/" + str(j) + ".txt","a") 
            file.write(event)
            # print("The event place is: {}, \nThe event date is: {}, \nThe event time is: {}, \nThe event is:\n {}".format(eventPlace, eventDate, eventTime, event))
            file.close()


def getTestData():
    """looping through the test date and returning the data as a String array"""
    testData = []
    for i in range(12):
        file = open("testData/test" + str(i) + ".txt", "r")
        text = file.readlines()
        file.close()
        testData.append("".join(text))
    return testData


if __name__== "__main__":
    main()