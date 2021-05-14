# big_data_project
Big Data final project ETL and Profiling process

## input:
1. dota_data.csv - original dota data obtained from Open Dota API data explorer (https://www.opendota.com/explorer?)
3. tail_games1-4.csv - original league of legends data obtained from Kaggle (https://www.kaggle.com/kdanielive/lol-partchallenger-1087?select=tail_games4.csv)
3. riot_champion.csv - original league of legends champion data with id obtained from Kaggle (https://www.kaggle.com/gyejr95/league-of-legendslol-champion-and-item-2020)

## Output.zip: 
zipped file for cleaned and profiled outputs
champion_clean.csv - cleaned riot_champion.csv file
dota_hero.csv - original dota hero data obtained from Open Dota API data explorer (https://www.opendota.com/explorer?). No cleaning needed.
game_output.csv - cleaned dota and league match data from dota_data.csv and tail_games1-4.csv, merged together on HDFS

## data_profiling:
CountRecs - java mapreduce code written to count the number of records in the dataset
original_results - number of records before cleaning for the 4 input datasets
cleaned_result - number of records after cleaning
    number for game_output.csv = flattend tail_games files + cleaned dota data file - useless rows
    number for champion_clean.csv
    didn't run on dota_hero.csv again because there's no need to clean it

## data_cleaning:
dota_cleaning - mapreduce job to clean dota_data.csv, output dota_clean.csv
    dropped useless columns
    added one column to indicate it's dota game
lol_cleaning1-4 - mapreduce jobs to clean tail_games1-4.csv separately, output lol_clean1-4.csv
    dropped useless columns and rows
    added one column to indicate it's dota game
    splitted one row each match with 1518 columns to around 20 rows per match (more rows but less columns)
    made it same schema as dota_clean.csv
    Since the four orginal datasets's columns are different (no patterns where columns we need are located), we have to process each dataset separately.
hero - mapreduce jobs to clean riot_champions.csv, output champion_clean.csv
    dropped useless columns and mantained only id and name
merged_file.png - screenshot from peel command to merge game output datasets together
    merge dota_clean.csv, lol_clean1-4.csv to game_output.csv
    





 


