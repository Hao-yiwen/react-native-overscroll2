import {
  codegenNativeComponent,
  type CodegenTypes,
  type HostComponent,
  type ViewProps,
} from 'react-native';

export type OnOverscrollEvent = Readonly<{
  state: CodegenTypes.Int32;
  offset: CodegenTypes.Float;
}>;

export interface NativeProps extends ViewProps {
  bounce: boolean;
  onOverscroll?: CodegenTypes.DirectEventHandler<
    OnOverscrollEvent,
    'onOverscroll'
  >;
}

export default codegenNativeComponent<NativeProps>(
  'OverscrollView'
) as HostComponent<NativeProps>;
