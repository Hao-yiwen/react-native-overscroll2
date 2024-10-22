import { useState } from 'react';
import { StyleSheet, View, Text, FlatList } from 'react-native';
import { OverscrollView } from 'react-native-overscroll2';

const MyComponent = () => {
  return (
    <OverscrollView
      bounce={true}
      onOverscroll={(event) => {
        console.log(
          'onOverscroll',
          event.nativeEvent.state,
          event.nativeEvent.offset
        );
      }}
    >
      <FlatListWithRefresh />
    </OverscrollView>
  );
};

const FlatListWithRefresh = () => {
  const [data, _] = useState(
    Array.from({ length: 20 }, (_, i) => `Item ${i + 1}`)
  );

  const renderItem = ({ item }: any) => (
    <View style={styles.item}>
      <Text style={{ color: 'black' }}>{item}</Text>
    </View>
  );

  return (
    <FlatList
      data={data}
      keyExtractor={(_item, index) => index.toString()}
      renderItem={renderItem}
      overScrollMode="always"
    />
  );
};

const styles = StyleSheet.create({
  item: {
    padding: 16,
    borderBottomWidth: 1,
    borderBottomColor: '#ccc',
  },
  container: {
    flex: 1,
    marginTop: 50,
  },
  box: {
    height: 150,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'pink',
    marginVertical: 10,
  },
  text: {
    fontSize: 20,
    color: 'black',
  },
});

export default MyComponent;
